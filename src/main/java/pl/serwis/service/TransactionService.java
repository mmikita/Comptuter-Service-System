package pl.serwis.service;

import java.util.Date;
import java.util.List;

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
		tr.setStartDate(new Date());
		repository.save(tr);
	}
	 public List<Transaction> getAllTransactions()
	 {
		 List<Transaction> allRepairs = repository.findAll();
	 return allRepairs;
	 }
	 
	 public void updateTransaction(String id, String status)
	 {
		 Transaction tr = repository.findOne(Long.parseLong(id));
		 tr.setStatus(status);
		 repository.save(tr);
		 //System.out.println(tr);
		// repository.save(tr);
		 
	 }
	
	
}
