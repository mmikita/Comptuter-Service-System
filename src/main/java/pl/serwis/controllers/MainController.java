package pl.serwis.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.seriws.model.Transaction;
import pl.serwis.service.TransactionService;

@Controller
public class MainController {
	
	@Autowired
	TransactionService service;

	@RequestMapping("/serwis")
	public String mainController() {

		return "MainPage";
	}

	@RequestMapping("/serwis/add")
	public String addTransaction(ModelMap model) {
		Transaction tr = new Transaction();
		tr.setStartDate(new Date());
		model.put("tr", tr);
		return "addTransactionForm";
	}
	
	@RequestMapping(value = "/serwis/add", method=RequestMethod.POST)
	public String addTransactionPost(@ModelAttribute Transaction tr) {
	
		service.addTranstacion(tr);
		return "MainPage";
	}

}
