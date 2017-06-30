package pl.serwis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.serwis.model.Transaction;
import pl.serwis.repository.TransactionRepository;

@Service
public class FilterByStatusService
{
	
	

	@Autowired
	TransactionRepository repository;
/**all - uzywany dla wszystkich stanow **/
	public List<Transaction> FilterByStatus(String state) {
		
		List<Transaction> transactions = repository.findAll();
		
		//System.out.println(transactions);

		transactions = transactions.stream().filter(n -> (n.getStatus().equals(state)))
			.collect(Collectors.toList());
	return transactions;
		
		//		if (state.equals("all")) {
//
//			transactions = transactions.stream().filter(n -> (n.getPrice() >= min) && (n.getPrice() <= max))
//					.collect(Collectors.toList());
//			return transactions;
//
//		}
//		else 
//		{
//			transactions = transactions.stream().filter(n -> (n.getPrice() >= min) && (n.getPrice() <= max) && n.getStatus().equals(state))
//					.collect(Collectors.toList());
//		}
		
		
	}

}
