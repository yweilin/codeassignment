package fi.assignment.countriesviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountriesViewServiceApplication {

	/**
	 * The Countries View Service which runs on localhost at port 8084 provides service to view real country data.
	 */
	public static final String COUNTRIES_SERVICE_ROOT_URL = "http://localhost:8083/countries";

	public static void main(String[] args) {
		SpringApplication.run(CountriesViewServiceApplication.class, args);
	}

}
