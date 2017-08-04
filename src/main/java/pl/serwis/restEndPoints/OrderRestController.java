package pl.serwis.restEndPoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.serwis.model.Transaction;
import pl.serwis.service.TransactionService;

@RestController
public class OrderRestController {

	@Autowired
	TransactionService tService;
	
    @CrossOrigin
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<List<Transaction>> getAll()
	{
		List<Transaction> allTransactions = tService.getAllTransactions();
		return ResponseEntity.ok(allTransactions);
		
	}
	
	
	
}
