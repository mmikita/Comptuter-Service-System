package pl.serwis.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.serwis.service.NotesService;

@Controller
public class NoteDeleteController {


	@Autowired
	public NotesService service;
	
	
	
	@RequestMapping(value = "/serwis/deleteNote", method = RequestMethod.POST)
	public String deleteNote(HttpServletRequest req)
	{	
		String id = req.getParameter("id");

		service.deleteNote(id);
		
		return "redirect:/serwis/notes";
	}

	
	
}
