package spring.addressbook.web;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import spring.addressbook.data.EntryRepository;
import spring.addressbook.pojos.Entry;

public class EntryControllerTest {

	@Test
	public void testEntriesByLetter() throws Exception {
		
		List<Entry> entries = createEntryList(10);
		
		// mock entry repository
		EntryRepository mockRepo = mock(EntryRepository.class);		
		when(mockRepo.getEntriesByLetter("f", 100)).thenReturn(entries);
		
		EntryController controller = new EntryController(mockRepo);
		
		MockMvc mockMvc = standaloneSetup(controller).build();
		
		// perform get request and verify that model is being populated
		mockMvc.perform(get("/entry?startsWith=f&count=100"))
			.andExpect(view().name("entries"))
			.andExpect(model().attributeExists("entryList"))
			.andExpect(model().attribute("entryList", Matchers.hasItems(entries.toArray())));
		
		
	}

	private List<Entry> createEntryList(int i) {
		
		List<Entry> entries = new ArrayList<Entry>();
		
		for (int j = 0; j < i; j++) {
			Entry entry = new Entry("j", "frizzle");			
			entries.add(entry);
		}
		
		return entries;
	}

}
