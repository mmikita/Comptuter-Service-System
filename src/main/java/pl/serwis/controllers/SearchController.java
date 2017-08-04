package pl.serwis.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.serwis.model.Transaction;
import pl.serwis.service.SearchService;

@Controller
public class SearchController {
	List<String> states = new ArrayList<String>();


	@Autowired
	SearchService service;

	public SearchController() {
		states = new ArrayList<String>();
		states.add("oczekujaca");
		states.add("w trakcie");
		states.add("zakonczona");
		states.add("nieodbyta");

	}
	
	
	@RequestMapping(value = "/serwis/search", method = RequestMethod.POST)
	public String Search(HttpServletRequest req, ModelMap model) {
	String searchText = req.getParameter("text");
List<Transaction> transactions = service.search(searchText);		
model.addAttribute("transactions", transactions);
model.addAttribute("states", states);

		return "TransactionsList";
	}
}
