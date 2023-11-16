package fi.assignment.countriesviewservice.controller;

import fi.assignment.countriesviewservice.modle.Country;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

import static fi.assignment.countriesviewservice.CountriesViewServiceApplication.COUNTRIES_SERVICE_ROOT_URL;

/**
 * This class fetches real country data using Countries Service.
 * The communication with Countries Service is handled using String WebFlux.
 */
@Controller
public class CountriesViewController {

    private final WebClient webClient = WebClient.create();

    @GetMapping("/country")
    public String getCountry(@RequestParam(defaultValue = "Finland") String name, Model model) {
        // Retrieve a country by send asynchronous request to Countries Service
        Mono<Country> response = webClient.get()
                .uri(COUNTRIES_SERVICE_ROOT_URL + "/" + name)
                .retrieve()
                .bodyToMono(Country.class)
                .log();

        Country country = response.block();

        model.addAttribute("name", "Parameter from path" + name);
        model.addAttribute("methodName", "calling from getCountry()");
        model.addAttribute("country", country);

        // The return value must match the file name(country.html) under templates directory
        return "country";
    }

    @GetMapping("/countries")
    public String getCountries(Model model) {
        // Retrieve countries by send asynchronous request to Country Service
        Mono<List<Country>> response = webClient
                .get()
                .uri(COUNTRIES_SERVICE_ROOT_URL)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {});
        List<Country> countries = response.block();

        assert countries != null;

        model.addAttribute("methodName", "calling from getCountries()");
        model.addAttribute("countries", countries.stream().toList());

        // The return value must match the file name(countries.html) under templates directory
        return "countries";
    }

}
