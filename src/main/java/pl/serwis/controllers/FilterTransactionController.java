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

import pl.serwis.model.Transaction;
import pl.serwis.service.FilterByStatusService;
import pl.serwis.service.FilterDateService;
import pl.serwis.service.FilterPriceService;

@Controller
public class FilterTransactionController {
	List<String> states = new ArrayList<String>();

	@Autowired
	FilterPriceService priceService;

	@Autowired
	FilterDateService dateService;

	@Autowired
	FilterByStatusService statusService;

	public FilterTransactionController() {
		states = new ArrayList<String>();
		states.add("oczekujaca");
		states.add("w trakcie");
		states.add("zakonczona");
		states.add("nieodbyta");

	}

	@RequestMapping(value = "/serwis/allRepairs/filterByDate", method = RequestMethod.POST)
	public String FilterByDate(HttpServletRequest req, ModelMap model) throws ParseException {
		DateFormat formatter = new SimpleDateFormat("yyy-MM-dd");

		String minStr = req.getParameter("startDate");
		String maxStr = req.getParameter("endDate");
		// System.out.println(minStr + " " + maxStr);
		Date startDate = formatter.parse(minStr);
		Date endDate = new Date();
		if (maxStr != "")
			endDate = formatter.parse(maxStr);
		String state;
		if (req.getParameter("state") != null) {
			state = req.getParameter("state");
			req.getSession().setAttribute("state", state);
		} else if (req.getSession().getAttribute("state") != null) {
			state = (String) req.getSession().getAttribute("state");
		} else {
			state = (String) req.getSession().getAttribute("state");

		}

		List<Transaction> transactions = dateService.FilterByDate(startDate, endDate, state);
		model.addAttribute("transactions", transactions);
		req.getSession().setAttribute("transactions", transactions);
		model.addAttribute("states", states);

		return "TransactionsList";
	}

	@RequestMapping(value = "/serwis/allRepairs/filterByCost", method = RequestMethod.POST)
	public String FilterByPrice(HttpServletRequest req, ModelMap model) {
		String min = req.getParameter("min");
		String max = req.getParameter("max");
		String state;

		if (req.getParameter("state") != null) {
			state = req.getParameter("state");
			req.getSession().setAttribute("state", state);
		} else if (req.getSession().getAttribute("state") != null) {
			state = (String) req.getSession().getAttribute("state");
		} else {
			state = (String) req.getSession().getAttribute("state");

		}

		List<Transaction> transactions = priceService.FilterByPrice(min, max, state);
		model.addAttribute("transactions", transactions);
		req.getSession().setAttribute("transactions", transactions);
		model.addAttribute("states", states);

		return "TransactionsList";
	}

	@RequestMapping(value = "/serwis/filterByStatus/{status}", method = RequestMethod.GET)
	public String FilterByStatus(HttpServletRequest req, @PathVariable String status, ModelMap model) {

		List<Transaction> transactions = statusService.FilterByStatus(status);
		model.addAttribute("transactions", transactions);
		req.getSession().setAttribute("transactions", transactions);
		model.addAttribute("states", states);

		return "TransactionsList";
	}

}
