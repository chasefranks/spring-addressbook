package spring.addressbook.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.addressbook.data.EntryRepository;
import spring.addressbook.pojos.Entry;

@Controller
@RequestMapping("/searches")
public class SearchesController {
	
	private EntryRepository repo;
	
	@Autowired
	public SearchesController(EntryRepository repo) {
		this.repo = repo;
	}
	
	@RequestMapping(value="", method=POST)
	public String search(@RequestParam(value="searchparm") String text, Model model) {
		
		model.addAttribute("entryListHeader", "Search Results");
		
		List<Entry> entries = repo.getEntriesByText(text);	
		model.addAttribute(entries);
		
		return "entries";		
	}

}
