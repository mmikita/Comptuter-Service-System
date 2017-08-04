package pl.serwis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.serwis.model.Transaction;
import pl.serwis.repository.TransactionRepository;

@Service
public class SearchService {

	@Autowired
	TransactionRepository repository;
	
	
	public List<Transaction> search(String text)
	{
		List<Transaction> transactions = repository.findAll();
		
		transactions = transactions.stream().filter(n -> n.getClientName().contains(text)
				||n.getClientLastName().contains(text)
				||n.getClientmail().contains(text)
				||n.getSerialNumber().contains(text)
				||n.getPhoneNumber().contains(text)
				||n.getModel().contains(text)
				||n.getComments().contains(text)
				).collect(Collectors.toList());
		
		
		
		return transactions;
				
	}
	
	
}
