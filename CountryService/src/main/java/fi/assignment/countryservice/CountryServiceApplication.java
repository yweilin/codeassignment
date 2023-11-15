package fi.assignment.countryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Country Service which runs on localhost at port 8081 provides service to fetch country data.
 */
@SpringBootApplication
public class CountryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}

}
