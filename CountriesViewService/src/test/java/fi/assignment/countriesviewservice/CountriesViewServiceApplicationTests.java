package fi.assignment.countriesviewservice;

import fi.assignment.countriesviewservice.controller.CountriesViewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CountriesViewServiceApplicationTests {

	@Autowired
	CountriesViewController countriesViewController;

	@Test
	void contextLoads() {
		assertThat(countriesViewController).isNotNull();
	}

}
