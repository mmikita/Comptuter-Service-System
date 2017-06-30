package pl.seriws.service;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import pl.serwis.model.Transaction;
import pl.serwis.repository.TransactionRepository;
import pl.serwis.service.FilterDateService;
import pl.serwis.service.FilterPriceService;

@RunWith(MockitoJUnitRunner.class)
public class FilterTest {
	ObjectMapper mapper = new ObjectMapper();
	@Mock
	private TransactionRepository repository;
	@InjectMocks
	FilterPriceService service = new FilterPriceService();
	@InjectMocks
	FilterDateService serviceDate = new FilterDateService();
	
	List<Transaction> transactions = Lists.newArrayList();
	@Before
	public void PrepareTransactions() throws JsonParseException, JsonMappingException, IOException {
		Transaction[] array = mapper.readValue(new File(
				System.getProperty("user.dir") + "\\src\\main\\resources\\initTransatcions\\listTransaction.json"),
				Transaction[].class);
		transactions = Arrays.asList(array);
		Mockito.when(repository.findAll()).thenReturn(transactions);
	}
	@Test
	public void FilterByPriceForAllStatesTest() {
		// Koszt naprawy miesci sie w przedziale
		int min = new Random().nextInt(200 - 100) + 100;
		int max = new Random().nextInt(200 - 100) + 100;
		transactions = service.FilterByPrice(String.valueOf(min), "200", "all");
		for (Transaction tr : transactions) {
			Assert.assertTrue("Wartosc jest mniejsza od wylosowanej minimalnej", tr.getPrice() >= min); // Check
																										// if
																										// value
																										// not
																										// exceed
																										// minimum
																										// value
			Assert.assertTrue("Wartosc jest wieksza od 200", tr.getPrice() <= 200); // Check
																					// if
																					// value
																					// not
																					// exceed
																					// maximum
																					// value
		}
		transactions = service.FilterByPrice("100", String.valueOf(max), "all");
		for (Transaction tr : transactions) {
			Assert.assertTrue("Wartosc jest mniejsza od 100", tr.getPrice() >= 100); // Check
																						// if
																						// value
																						// not
																						// exceed
																						// minimum
																						// value
			Assert.assertTrue("Wartosc jest mniejsza od wylosowanej maksymalnej", tr.getPrice() <= max); // Check
																											// if
																											// value
																											// not
																											// exceed
																											// maximum
																											// value
		}

	}
	@Test
	public void FilterByPriceTestForEachState() {
		transactions = service.FilterByPrice("50", "250", "oczekujaca");
		for (Transaction tr : transactions) {
			Assert.assertTrue("Wartosc jest mniejsza od 100", tr.getPrice() >= 50);
			Assert.assertTrue("Wartosc jest wieksza od 200", tr.getPrice() <= 250); 

			Assert.assertTrue("stan naprawy sie nie zgadza",tr.getStatus().equals("oczekujaca"));
		}
		transactions = service.FilterByPrice("50", "250", "w trakcie");
		for (Transaction tr : transactions) {

			Assert.assertTrue("Wartosc jest mniejsza od 100", tr.getPrice() >= 50);
			Assert.assertTrue("Wartosc jest wieksza od 200", tr.getPrice() <= 250); 

			Assert.assertTrue("stan naprawy sie nie zgadza",tr.getStatus().equals("w trakcie"));
		}

		transactions = service.FilterByPrice("50", "250", "zakonczona");
		for (Transaction tr : transactions) {

			Assert.assertTrue("Wartosc jest mniejsza od 100", tr.getPrice() >= 50);
			Assert.assertTrue("Wartosc jest wieksza od 200", tr.getPrice() <= 250);

			Assert.assertTrue("stan naprawy sie nie zgadza", tr.getStatus().equals("zakonczona"));
		}
		
		transactions = service.FilterByPrice("50", "250", "nieodbyta");
		for (Transaction tr : transactions) {

			Assert.assertTrue("Wartosc jest mniejsza od 100", tr.getPrice() >= 50);
			Assert.assertTrue("Wartosc jest wieksza od 200", tr.getPrice() <= 250);

			Assert.assertTrue("stan naprawy sie nie zgadza", tr.getStatus().equals("nieodbyta"));
		}
	}
	
	@Test
	public void FilterByDateForEachStateTest()
	{
		System.out.println(transactions);
		transactions = service.FilterByPrice("50", "250", "oczekujaca");

		
		
	}

}
