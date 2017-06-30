package pl.serwis.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.serwis.model.Transaction;
import pl.serwis.repository.TransactionRepository;

@Service
public class ListInitTest {

	@Autowired
	TransactionRepository repository;
	
	public void initList() throws JsonParseException, JsonMappingException, IOException
	{
		
		ObjectMapper mapper = new ObjectMapper();
		Transaction[] array = mapper.readValue(new File(System.getProperty("user.dir") + "\\src\\main\\resources\\initTransatcions\\listTransaction.json"),  Transaction[].class);
		List<Transaction> transArray = Arrays.asList(array);
		saveTestRepairsToDatabase(transArray);
	}
	
	
	public void saveTestRepairsToDatabase(List<Transaction> transactions)
	{
		for(Transaction tr : transactions)
		{
			repository.save(tr);
		}
		
	}
	
	
}
