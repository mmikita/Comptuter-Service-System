
package pl.serwis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.serwis.model.Note;
import pl.serwis.repository.NotesRepository;

@Service
public class NotesService {

	@Autowired
	NotesRepository repository;

	public List<Note> getAllNotes() {

		List<Note> allNotes = repository.findAll();

		return allNotes;
	}

	public void addNote(String info) {
		
		Note note = new Note();
		note.setNote(info);
		repository.save(note);

	}
	
	public void editNote(String id, String newNote)
	{
		Note note = repository.findOne(Long.parseLong(id));
		note.setNote(newNote);
		repository.save(note);
		
	}

	public void deleteNote(String id)
	{
		repository.delete(Long.valueOf(id));
		
	}
	
}
