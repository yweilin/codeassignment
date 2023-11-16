package fi.assignment.countriesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Countries Service which runs on localhost at port 8083 provides service to fetch real country data.
 */
@SpringBootApplication
public class CountriesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountriesServiceApplication.class, args);
	}

}
