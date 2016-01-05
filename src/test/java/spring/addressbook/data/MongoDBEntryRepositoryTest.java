package spring.addressbook.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import spring.addressbook.pojos.Address;
import spring.addressbook.pojos.EmailAddress;
import spring.addressbook.pojos.Entry;
import spring.addressbook.pojos.PhoneNumber;

@Ignore
public class MongoDBEntryRepositoryTest {
	
	private static EntryRepository entryRepository;
		
	@BeforeClass
	public static void setUpBefore() {
//		entryRepository = new MongoDBEntryRepository("spring-addressbook-unit-tests", "entries");
	}

	@Test
	public void testGetEntryByFirstNameAndLastName() {
		
	}
	
	@Test
	public void testAddEntry() throws Exception {		
				
	}
	
	@Test
	public void testGetEntriesByLastName() {
					
	}
	
	@Test
	public void testGetEntryById() {
				
	}
	
	@Test
	public void testRemoveEntry() {
		
	}
	
	@Test
	public void testGetEntriesByLetter() {
		
	}
	
	@Test
	public void testGetEntriesByLetterEmpty() {		
		
	}
}
