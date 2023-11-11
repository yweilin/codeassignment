package fi.assignment.countryservice;

import fi.assignment.countryservice.controller.CountryController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CountryServiceApplicationTests {

    @Autowired
    private CountryController countryController;

    @Test
    void contextLoads() {
        assertThat(countryController).isNotNull();
    }

}
