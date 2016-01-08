package spring.addressbook.web;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.addressbook.data.EntryRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	EntryRepository repo;

	@RequestMapping("/")
	public String getHome(Model model) {
		
		// fill model with counts per first letter of last name
		List<EntryCount> counts = IntStream.range('A', 'Z' + 1)
			.mapToObj(i -> Character.toString((char) i))
			.map(letter -> 	new EntryCount(letter, repo.getEntryCountByLetter(letter)))
			.collect(toList());
		
		model.addAttribute(counts);
						
		return "index";
		
	}
	
	public class EntryCount{
		
		public String letter;
		public long count;
		
		public EntryCount(String letter, long count) {
			this.letter = letter;
			this.count = count;
		}
		
		public String getLetter() {
			return letter;
		}

		public void setLetter(String letter) {
			this.letter = letter;
		}

		public long getCount() {
			return count;
		}

		public void setCount(long count) {
			this.count = count;
		}
		
	}
	
}
