 package pl.serwis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.serwis.model.Note;

@Repository
public interface NotesRepository extends JpaRepository<Note, Long> 
{
	

}
