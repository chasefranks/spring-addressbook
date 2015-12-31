package spring.addressbook.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.addressbook.data.EntryRepository;
import spring.addressbook.pojos.Address;
import spring.addressbook.pojos.Entry;

@Controller
@RequestMapping("/entry")
public class EntryController {
	
	private EntryRepository entryRepository;
	
	@Autowired
	public EntryController(EntryRepository entryRepository) {
		this.entryRepository = entryRepository;
	}
	
	@RequestMapping(method=GET)
	public String entriesByLetter(@RequestParam("startsWith") String startsWith, @RequestParam("count") int count, Model model) {
		
		/*
		 * query repository for list of Entries with last name starting with the query parameter 'startsWith'
		 */
		List<Entry> entriesByLetter = entryRepository.getEntriesByLetter(startsWith, count);
		
		// add list to model
		model.addAttribute(entriesByLetter);
		model.addAttribute("entryListHeader", startsWith.toUpperCase());
		
		// return the view name
		return "entries";
		
	}
	
	@RequestMapping(value="/add", method=GET)
	public String getAddEntry() {
		return "addentry";
	}
	
	@RequestMapping(value="/add", method=POST)
	public String addNewEntry(Entry entry, Model model) {
		
		entryRepository.addEntry(entry);
		
		// we'll cheat for now and just add the entry to the model
		model.addAttribute("entryListHeader", "Entry Created");
		model.addAttribute(Arrays.asList(entry));
		
		return "entries";
		
	}
	
	

}
