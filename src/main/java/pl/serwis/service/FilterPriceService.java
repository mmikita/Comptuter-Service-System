package pl.serwis.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import pl.serwis.model.Transaction;
import pl.serwis.repository.TransactionRepository;

@Service
public class FilterPriceService {
	
	
	
	@Autowired
	TransactionRepository repository;
/**all - uzywany dla wszystkich stanow **/
	public List<Transaction> FilterByPrice(String minPrice, String maxPrice, String state) {
		double min = Double.parseDouble(minPrice);
		double max = Double.parseDouble(maxPrice);
		List<Transaction> transactions = Lists.newArrayList();
		 transactions = repository.findAll();
		if (state.equals("all")) {

			transactions = transactions.stream().filter(n -> (n.getPrice() >= min) && (n.getPrice() <= max))
					.collect(Collectors.toList());
			return transactions;

		}
		else 
		{
			transactions = transactions.stream().filter(n -> (n.getPrice() >= min) && (n.getPrice() <= max&&
					n.getStatus().equals(state)) && n.getStatus().equals(state))
					.collect(Collectors.toList());
		}
		
		
		return transactions;
	}

}
