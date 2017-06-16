package pl.seriws.serwis;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.seriws.model.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SerwisApplicationTests {

	@Test
	public void contextLoads() throws JsonGenerationException, JsonMappingException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
//		Transaction tr = createDummy();
//		mapper.writeValue(new File("C:\\Users\\Paster0\\Desktop\\serwis\\testP.json"), tr);


System.out.println("DZIAlaj!!!!!");
//		List<Transaction> trRead = mapper.readValue(new File("C:\\Users\\Paster0\\Desktop\\serwis\\listTransaction.json"), new List<Transaction>(){});
		Transaction[] array = mapper.readValue(new File("C:\\Users\\Paster0\\Desktop\\serwis\\listTransaction.json"),  Transaction[].class);
		List<Transaction> transArray = Arrays.asList(array);
		System.out.println(transArray);
	

	
	}

	private Transaction createDummy() {
		Transaction tr = new Transaction();
		tr.setClientLastName("ogorek");
		tr.setId(1L);
		tr.setPrice(334);
		tr.setClientName("fsdfsd");
		tr.setSerialNumber("fdsfa");
		tr.setPhoneNumber("fdsfs");
		tr.setClientmail("@@");
		tr.setStartDate(new Date());
		tr.setEndDate(new Date());
		tr.setModel("asdas");
		tr.setComments("fdsf");
		tr.setDeliveryMethod("pichota");
		return tr;
	}

}
