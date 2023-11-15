package fi.assignment.countryviewservice;

import fi.assignment.countryviewservice.controller.CountryViewController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryViewServiceApplicationTests {

	@Autowired
	private CountryViewController countryViewController;

	@Test
	void contextLoads() {
		assertThat(countryViewController).isNotNull();
	}

}
