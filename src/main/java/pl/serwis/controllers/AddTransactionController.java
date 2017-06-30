package pl.serwis.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.serwis.model.Transaction;
import pl.serwis.service.TransactionService;

@Controller
public class AddTransactionController {
	
	@Autowired
	TransactionService service;
	List<String> states = new ArrayList<String>();

	public AddTransactionController()
	{
		states = new ArrayList<String>();
		states.add("oczekujaca");
		states.add("w trakcie");
		states.add("zakonczona");
		states.add("nieodbyta");

	}

	@RequestMapping("/serwis")
	public String mainController() {

		return "redirect:/serwis/allRepairs";
	}

	@RequestMapping("/serwis/add")
	public String addTransaction(ModelMap model) {
		Transaction tr = new Transaction();
		tr.setStartDate(new Date());
		model.put("tr", tr);
		return "addTransactionForm";
	}
	
	@RequestMapping(value = "/serwis/add", method=RequestMethod.POST)
	public String addTransactionPost(@ModelAttribute Transaction tr, ModelMap model) {
	
		service.addTranstacion(tr);
		List<Transaction> transactions = service.getAllTransactions();
		model.addAttribute("transactions", transactions);
		model.addAttribute("states", states);

		return "TransactionsList";
	}

}
