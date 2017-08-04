package pl.serwis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.serwis.service.SendEmailService;

@Controller
public class MailController {

	@Autowired
	SendEmailService service;

	@RequestMapping(value = "/serwis/send")
	public String sendEmail(ModelMap model) {
		//System.out.println("wysylam...");
		service.send();
return "redirect:/serwis/allRepairs";
	}

}
