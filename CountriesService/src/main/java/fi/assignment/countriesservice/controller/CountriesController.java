package fi.assignment.countriesservice.controller;

import fi.assignment.countriesservice.modle.Country;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

/**
 * This class handles fetching real data using REST Countries service.
 */
@RestController
public class CountriesController {

    private static final String REST_COUNTRIES_API_ROOT = "https://restcountries.com/v3.1";
    private static final String RESET_COUNTRIES_API_FIELD_FILTER =
            REST_COUNTRIES_API_ROOT + "/all?fields=name,flags,population,capital,cca2";
    private final WebClient webClient = WebClient.create();
    private List<Country> countries; // for debugging purpose

    @GetMapping("/countries")
    public List<Country> getCountries() {
        // Send asynchronous request to REST Countries Service
        Mono<List<Country>> response = webClient.get()
                .uri(RESET_COUNTRIES_API_FIELD_FILTER)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
        List<Country> countries = response.block();

        if (countries == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        this.countries = countries;
        return countries;
    }

    @GetMapping("/countries/{name}")
    public Country getCountry(@PathVariable String name) {
        Mono<List<Country>> response = webClient.get()
                .uri(REST_COUNTRIES_API_ROOT + "/name/" + name)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
        List<Country> country = response.block();

        if (country == null || country.get(0) == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return country.get(0);
    }

    private Country find(String name) {
        Optional<Country> result = countries.stream()
                .filter(country -> country.name.common.equals(name))
                .findFirst();
        return result.orElse(null);
    }
}
