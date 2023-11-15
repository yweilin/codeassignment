package fi.assignment.countryviewservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * The Country View Service which runs on localhost at port 8082 provides service to view data of countries.
 */
@SpringBootApplication
public class CountryViewServiceApplication {

	public static final String COUNTRY_SERVICE_ROOT_URL = "http://localhost:8081/countries";

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(CountryViewServiceApplication.class, args);
	}

}
