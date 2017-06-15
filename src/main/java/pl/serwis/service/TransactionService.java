package pl.serwis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.seriws.model.Transaction;
import pl.seriws.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	TransactionRepository repository;
	
	public void addTranstacion(Transaction tr)
	{
		repository.save(tr);
	}
	
	
	
}