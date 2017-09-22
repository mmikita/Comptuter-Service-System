package pl.serwis.testy;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;



@Controller
public class Testy {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		//restTemplate.getForObject("http://samples.openweathermap.org/data/2.5/find?q=London&units=imperial&appid=b1b15e88fa797225412429c1c50c122a1");
	}

}
