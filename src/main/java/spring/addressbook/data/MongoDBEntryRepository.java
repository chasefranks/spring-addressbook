package spring.addressbook.data;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.regex;
import static com.mongodb.client.model.Filters.text;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import spring.addressbook.pojos.Address;
import spring.addressbook.pojos.EmailAddress;
import spring.addressbook.pojos.Entry;
import spring.addressbook.pojos.PhoneNumber;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.IndexModel;
import com.mongodb.client.model.IndexOptions;

/**
 * An EntryRepository implementation utilizing MongoDB and the MongoDB
 * driver. This implementation provides the map from MongoDB documents
 * and our main POJOs, for example {@link Entry}.
 * 
 * @author chase
 *
 */
@Component
public class MongoDBEntryRepository implements EntryRepository {
	
	private MongoClient client;
	private MongoCollection<Document> collection;
	
	// static lambda expressions used to map between Documents and POJOs
	static final Function<Document, Address> docToAddress = doc -> new Address(
			doc.getString("number"),
			doc.getString("street"),
			doc.getString("city"),
			doc.getString("state"),
			doc.getString("postalCode") ) ;
	
	static final Function<Address, Document> addressToDoc = add -> new Document()
			.append("number", add.getNumber())
			.append("street", add.getStreet())
			.append("city", add.getCity())
			.append("state", add.getState())
			.append("postalCode", add.getPostalCode());
	
	static final Function<Document, PhoneNumber> docToPhoneNumber = doc -> new PhoneNumber(
			doc.getString("alias"), 
			doc.getString("number") );	
	
	static final Function<PhoneNumber, Document> phoneNumberToDoc = phone -> new Document()
			.append("alias", phone.getAlias())
			.append("number", phone.getNumber());
	
	static final Function<Document,EmailAddress> docToEmailAddress = doc -> new EmailAddress(
			doc.getString("alias"),
			doc.getString("address"));
	
	static final Function<EmailAddress, Document> emailAddressToDoc = email -> new Document()
			.append("alias", email.getAlias())
			.append("address", email.getAddress());
	
	static final Function<Document, Entry> docToEntry = doc -> {
		Entry entry = new Entry(doc.getString("firstName"), doc.getString("lastName"));
		
		entry.setId(doc.getObjectId("_id").toString());
		
		Document addressDoc = (Document) doc.get("address");
		
		if (addressDoc != null)
			entry.setAddress(docToAddress(addressDoc));
		
		Document phoneDoc = (Document) doc.get("phoneNumber");
		
		if (phoneDoc != null)
			entry.setPhoneNumber(docToPhoneNumber(phoneDoc));
		
		Document emailDoc = (Document) doc.get("emailAddress");
		
		if(emailDoc != null)
			entry.setEmailAddress(docToEmailAddress(emailDoc));
		
		return entry;
	};
	
	static final Function<Entry, Document> entryToDoc = entry -> {
		
		Document doc = new Document();
		
		if(entry.getId() != null) {
			doc.append("_id", new ObjectId(entry.getId()));
		}
		
		doc.append("firstName", entry.getFirstName());
		doc.append("lastName", entry.getLastName());
		
		if(entry.getAddress() != null) {
			doc.append("address", addressToDoc(entry.getAddress()));
		}
		
		if(entry.getPhoneNumber() != null) {
			doc.append("phoneNumber", phoneNumberToDoc(entry.getPhoneNumber()));
		}
		
		if(entry.getEmailAddress() != null) {
			doc.append("emailAddress", emailAddressToDoc(entry.getEmailAddress()));
		}
		
		return doc;
		
	};
	
	private static Document emailAddressToDoc(EmailAddress emailAddress) {
		return Stream.of(emailAddress).map(emailAddressToDoc).collect(toList()).get(0);
	}


	private static Document phoneNumberToDoc(PhoneNumber phoneNumber) {
		return Stream.of(phoneNumber).map(phoneNumberToDoc).collect(toList()).get(0);
	}

	private static Document addressToDoc(Address address) {
		return Stream.of(address).map(addressToDoc).collect(toList()).get(0);
	}


	private static PhoneNumber docToPhoneNumber(Document phoneDoc) {
		return Stream.of(phoneDoc).map(docToPhoneNumber).collect(toList()).get(0);
	}
	
	private static EmailAddress docToEmailAddress(Document emailDoc) {
		return Stream.of(emailDoc).map(docToEmailAddress).collect(toList()).get(0);
	}
	
	private static Address docToAddress(Document addressDoc) {
		return Stream.of(addressDoc).map(docToAddress).collect(toList()).get(0);
	}
	
	private Document entryToDoc(Entry entry) {		
		return Stream.of(entry).map(entryToDoc).collect(toList()).get(0);		
	}
	
	private Entry docToEntry(Document document) {
		
		if(document == null) {
			return null;
		}
		
		return Stream.of(document).map(docToEntry).collect(toList()).get(0);		
		
	}
	
	@Autowired
	public MongoDBEntryRepository(MongoClient client, @Value("${mongodb.database:addressbook}") String database, @Value("${mongodb.collection:entries}") String collection) {
		
		MongoDatabase db = client.getDatabase(database);		
		this.collection = db.getCollection(collection);
		
		createIndex();
		
	}	
	
	private void createIndex() {
		
		// check if the index already exists
		for (Document index: collection.listIndexes()) {
			if(index.get("name").equals("TextIndex")) {
				return;
			}
		}
		
		// otherwise create the index we'll need
		Document index = new Document()
							.append("firstName", "text")
							.append("lastName", "text")
							.append("address.street", "text")
							.append("address.city", "text")
							.append("emailAddress.address", "text");		
		
		collection.createIndex(index, new IndexOptions().name("TextIndex"));
		
	}


	@Override
	public Entry getEntryByFirstNameAndLastName(String firstName,
			String lastName) {
		
		Document doc = collection.find(and(eq("firstName", firstName), eq("lastName", lastName))).first();
		
		return docToEntry(doc);		
		
	}

	@Override
	public List<Entry> getEntriesByLastName(String lastName) {
		
		FindIterable<Document> iterable = collection.find(eq("lastName", lastName));
		
		/*
		 * this is a little new to me here...
		 * getting a stream from the Iterable returned from the call to .find() 
		 */
		Stream entryDocStream = StreamSupport.stream(iterable.spliterator(), false);
		
		// map each raw Document to an Entry using the lambda
		Stream entryStream = entryDocStream.map(docToEntry);
		
		return (List<Entry>) entryStream.collect(toList());		
		
	}
	
	@Override
	public Entry getEntryById(String id) {
		
		ObjectId oid = new ObjectId(id);
		
		Document doc = collection.find(eq("_id", oid)).first();
		
		return docToEntry(doc);
		
	}

	@Override
	public Entry addEntry(Entry entry) {
		
		Document doc = entryToDoc(entry);
		
		collection.insertOne(doc);
		
		return docToEntry(doc);
		
	}

	@Override
	public void removeEntry(String id) {		
		collection.deleteOne(eq("_id", new ObjectId(id)));
	}	
		
	@Override
	public List<Entry> getEntriesByLetter(String letter, int count) {
		
		String regex = "^" + letter.charAt(0);
		
		// send query
		FindIterable<Document> iterable = collection.find(Filters.regex("lastName", regex, "i")).limit(count);
		
		Stream docStream = StreamSupport.stream(iterable.spliterator(), false);
		
		return (List<Entry>) docStream.map(docToEntry).collect(toList());		
		
	}

	@Override
	public List<Entry> getEntriesByLetter(String letter, String after, int count) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public long getEntryCountByLetter(String letter) {
		
		String regex = "^" + letter.charAt(0);		
		return collection.count(regex("lastName", regex, "i"));		
		
	}


	@Override
	public List<Entry> getEntriesByText(String text) {
		
		/*
		 * for text search to work, we need to have created the following index in our database
		 * assuming the collection is called 'entries', this could look something like
		 * 
		 * db.entries.createIndex({ 
		 * 	firstName:"text", 
		 * 	lastName:"text", 
		 * 	'address.street':"text",
		 * 	'address.city':"text", 
		 * 	'emailAddress.address':"text"}, 
		 * 	{
		 * 		weights: {
		 * 			firstName:5, 
		 * 			lastName:10, 
		 * 			'address.street':2, 
		 * 			'address.city':3, 
		 * 			'emailAddress.address':1
		 * 		}, 
		 * 		name:"TextIndex"
		 * 	})
		 * 
		 */
		
		FindIterable<Document> iterable = collection.find(text(text));
		
		Stream docStream = StreamSupport.stream(iterable.spliterator(), false);
		
		return (List<Entry>) docStream.map(docToEntry).collect(toList());		
		
	}

}
