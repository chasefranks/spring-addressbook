package spring.addressbook.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/searches")
public class SearchesController {
	
	@RequestMapping(value="", method=POST)
	public String search(Model model) {			
		model.addAttribute("entryListHeader", "Search Results");
		return "entries";		
	}

}
