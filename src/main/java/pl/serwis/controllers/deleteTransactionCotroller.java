package pl.serwis.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.serwis.service.TransactionService;

@Controller
public class deleteTransactionCotroller {

	@Autowired
	TransactionService service;

	@RequestMapping(value = "/serwis/deleteOne", method = RequestMethod.POST)
	public String deleteTransaction(HttpServletRequest req, ModelMap model) {
		
		service.deleteTransactionById(req.getParameter("id"));


		return "redirect:/serwis/allRepairs";
	}

}
