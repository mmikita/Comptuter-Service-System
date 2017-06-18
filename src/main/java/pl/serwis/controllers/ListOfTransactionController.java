package pl.serwis.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import pl.seriws.model.Transaction;
import pl.serwis.service.ListInitTest;
import pl.serwis.service.TransactionService;

@Controller
public class ListOfTransactionController {

	@Autowired
	ListInitTest service;

	@Autowired
	TransactionService tService;
	
	@RequestMapping("/serwis/allRepairs")
	public String listOfAllTransactions(ModelMap model)
	{
	//List<String> states = Lists.newArrayList(new String[]{"oczekujaca","w trakcie","zakonczona"}); 
List<String> states = new ArrayList<String>();
states.add("oczekujaca");
states.add("w trakcie");
states.add("zakonczona");

	model.addAttribute("states", states);
		List<Transaction> allTransactions = tService.getAllTransactions();
		model.addAttribute("transactions", allTransactions);
		return "TransactionsList";
		       
	}
	
	@RequestMapping("/serwis/initTest")
	public String initTest(ModelMap model) throws JsonParseException, JsonMappingException, IOException
	{

		List<Transaction> allTransactions = tService.getAllTransactions();
		model.addAttribute("transactions", allTransactions);
		service.initList();
		return "TransactionsList";
		       
	}
	
}
