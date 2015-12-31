package spring.addressbook.data;

import java.util.List;

import spring.addressbook.pojos.Entry;

public interface EntryRepository {
	
	Entry getEntryByFirstNameAndLastName(String firstName, String lastName);
	
	List<Entry> getEntriesByLastName(String lastName);
	
	List<Entry> getEntriesByLetter(String letter, int count);
	
	List<Entry> getEntriesByLetter(String letter, String after, int count);
	
	Entry getEntryById(String id);
	
	Entry addEntry(Entry entry);
	
	void removeEntry(String id);	

}
