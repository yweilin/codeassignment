package fi.assignment.countriesservice;

import fi.assignment.countriesservice.controller.CountriesController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class CountriesServiceApplicationTests {

	@Autowired
	CountriesController countriesController;

	@Test
	void contextLoads() {
		assertThat(countriesController).isNotNull();
	}

}
