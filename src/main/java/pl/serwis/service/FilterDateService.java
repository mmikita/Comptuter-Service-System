package pl.serwis.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.serwis.model.Transaction;
import pl.serwis.repository.TransactionRepository;



@Service
public class FilterDateService {

	@Autowired
	TransactionRepository repository;

	public List<Transaction> FilterByDate(Date startDate, Date endDate, String state)
	{

		List<Transaction> transactions = Lists.newArrayList();
		 transactions = repository.findAll();
		// System.out.println(startDate+ " " + endDate);
		if (state.equals("all")) {

			transactions = transactions.stream()
					.filter(n -> ((n.getEndDate()!=null)&&(n.getStartDate().after(startDate)) && (n.getEndDate().before(endDate))))
					.collect(Collectors.toList());
			
			return transactions;

		}
		else 
		{
			transactions = transactions.stream().filter(n -> (n.getEndDate()!=null)&&(n.getStartDate().after(startDate)) && (n.getEndDate().before(endDate))&& n.getStatus().equals(state))
					.collect(Collectors.toList());
					
					
		}
		
		
		return transactions;	
		
		
	}	
	
}
