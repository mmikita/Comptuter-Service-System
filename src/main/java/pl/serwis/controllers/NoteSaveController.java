package pl.serwis.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.serwis.service.NotesService;

@Controller
public class NoteSaveController {
	
	@Autowired
	public NotesService service;
	
	@RequestMapping(value = "/serwis/addNote", method = RequestMethod.POST)
	public String addNote(HttpServletRequest req, ModelMap model)
	{	
		String note = req.getParameter("note");
		
		service.addNote(note);
		
		return "redirect:/serwis/notes";
	}

	
	@RequestMapping(value = "/serwis/editNote", method = RequestMethod.POST)
	public String editNote(HttpServletRequest req)
	{	
		String note = req.getParameter("note");
		String id = req.getParameter("id");

		service.editNote(id, note);
		
		return "redirect:/serwis/notes";
	}
	

	
	
	

}
