package pl.serwis.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.seriws.model.Transaction;
import pl.serwis.service.TransactionService;

@Controller
public class UpdateTransactionController 
{
	List<String> states = new ArrayList<String>();

public UpdateTransactionController()
{
	states = new ArrayList<String>();
	states.add("oczekujaca");
	states.add("w trakcie");
	states.add("zakonczona");
	states.add("nieodbyta");

}
	@Autowired
	TransactionService service;
	

	
	
	@RequestMapping(value = "/serwis/updateOne", method=RequestMethod.POST)
	public String updateTransaction(HttpServletRequest req, ModelMap model) {
	
		//System.out.println("id wynosi: " + req.getParameter("id"));
		//System.out.println("nowz status: " + req.getParameter("status"));
		long id = Long.valueOf(req.getParameter("id"));
		service.updateTransactionStatus(req.getParameter("id"), req.getParameter("status"));
		@SuppressWarnings("unchecked")
		List<Transaction> transactions = (List<Transaction>)req.getSession().getAttribute("transactions");
		List<Transaction> trs = (List<Transaction>) transactions.stream().filter(n -> (n.getId()==id)).limit(2).collect(Collectors.toList());
		trs.get(0).setStatus(req.getParameter("status"));
		model.addAttribute("transactions", transactions);
		model.addAttribute("states", states);
		return "TransactionsList";
	}

	@RequestMapping(value = "/serwis/repairDetails/{id}", method=RequestMethod.GET)
	public String TransactionDetails(ModelMap model, @PathVariable String id)
	{
		
		
Transaction tr = service.getTransactionById(id);
model.addAttribute("tr",tr);

		return "TransactionDetails";
	}
	
	@RequestMapping(value = "/serwis/editRepair/{id}", method=RequestMethod.GET)
	public String editTransaction(ModelMap model, @PathVariable String id)
	{
		Transaction tr = service.getTransactionById(id);
		model.addAttribute("tr", tr);
		return "EditTransaction";
	}
	
	@RequestMapping(value = "/serwis/editRepair", method=RequestMethod.POST)
	public String editTransactionPost(ModelMap model, @ModelAttribute Transaction tr)
	{
		System.out.println(tr.getId());
		service.updateTransaction(tr);
		//model.addAttribute("tr", tr);
		return "redirect:/serwis/repairDetails/"+ tr.getId();
	}
}
