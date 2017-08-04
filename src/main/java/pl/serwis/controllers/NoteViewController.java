package pl.serwis.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.serwis.model.Note;
import pl.serwis.service.NotesService;

@Controller
public class NoteViewController {

	@Autowired
	public NotesService service;
	
	
	@RequestMapping("/serwis/notes")
	public String notesView(ModelMap model)
	{
		
		List<Note> allNotes = service.getAllNotes();
		model.addAttribute("notes", allNotes);
		return "NotesView";
		

		
	}
	
	
	
	

	
}
