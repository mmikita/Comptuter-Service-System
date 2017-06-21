package pl.serwis.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.seriws.model.Transaction;
import pl.serwis.service.FilterByStatus;
import pl.serwis.service.FilterDateService;
import pl.serwis.service.FilterPriceService;

@Controller
public class FilterTransactionController {
	List<String> states = new ArrayList<String>();

	public FilterTransactionController() {
		states = new ArrayList<String>();
		states.add("oczekujaca");
		states.add("w trakcie");
		states.add("zakonczona");
		states.add("nieodbyta");

	}

	@Autowired
	FilterPriceService priceService;

	@Autowired
	FilterDateService dateService;
	

	@Autowired
	FilterByStatus statusService;

	@RequestMapping(value = "/serwis/allRepairs/filterByCost", method = RequestMethod.POST)
	public String FilterByPrice(HttpServletRequest req, ModelMap model) {
		String min = req.getParameter("min");
		String max = req.getParameter("max");
		String state = req.getParameter("state");
		List<Transaction> transactions = priceService.FilterByPrice(min, max, state);
		model.addAttribute("transactions", transactions);
		req.getSession().setAttribute("transactions", transactions);
		model.addAttribute("states", states);

		return "TransactionsList";
	}
	
	@RequestMapping(value = "/serwis/filterByStatus/{status}", method = RequestMethod.GET)
	public String FilterByStatus(HttpServletRequest req,@PathVariable String status, ModelMap model) {
	
List<Transaction> transactions = statusService.FilterByStatus(status);
model.addAttribute("transactions", transactions);
req.getSession().setAttribute("transactions", transactions);
model.addAttribute("states", states);

		return "TransactionsList";
	}

	@RequestMapping(value = "/serwis/allRepairs/filterByDate", method = RequestMethod.POST)
	public String FilterByDate(HttpServletRequest req, ModelMap model) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");

		String minStr = req.getParameter("startDate");
		String maxStr = req.getParameter("endDate");
	//	System.out.println(minStr + "  " + maxStr);
		Date startDate = formatter.parse(minStr);
		Date endDate = new Date();
		if(maxStr != "") endDate = formatter.parse(maxStr);
		String state = req.getParameter("state");
		List<Transaction> transactions = dateService.FilterByDate(startDate, endDate, state);
		model.addAttribute("transactions", transactions);
		req.getSession().setAttribute("transactions", transactions);
		model.addAttribute("states", states);

		return "TransactionsList";
	}

}
