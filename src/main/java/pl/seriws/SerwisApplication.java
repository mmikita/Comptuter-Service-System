package pl.seriws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@ComponentScan("pl.serwis")
@EnableJpaRepositories
@EntityScan
public class SerwisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerwisApplication.class, args);
	}
}
