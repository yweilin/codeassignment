package fi.assignment.countryviewservice.controller;

import fi.assignment.countryviewservice.modle.Country;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

import static fi.assignment.countryviewservice.CountryViewServiceApplication.COUNTRY_SERVICE_ROOT_URI;

@Controller
public class CountryViewController {

    private final WebClient webClient = WebClient.create();

    /**
     * Get country with given parameter of country name.
     * <p>
     * Usage example:
     * GET with default value: http://localhost:8082/country
     * GET with given parameter: http://localhost:8082/country?name=China
     */
    @GetMapping("/country")
    public String getCountry(@RequestParam(defaultValue = "Finland") String name, Model model) {
        // Retrieve a country by send asynchronous request to Country Service
        Mono<Country> response = webClient.get()
                .uri(COUNTRY_SERVICE_ROOT_URI + "/" + name)
                .retrieve()
                .bodyToMono(Country.class)
                .log();

        Country country = response.block();

        model.addAttribute("name", "Parameter from path" + name);
        model.addAttribute("methodName", "calling from getCountry()");
        model.addAttribute("country", country);

        // The return name must match the name of country.html
        return "country";
    }

    /**
     * Get all available countries.
     * <p>
     * Usage example:
     * GET: http://localhost:8082/countries
     */
    @GetMapping("/countries")
    public String getCountries(Model model) {
        // Retrieve countries by send asynchronous request to Country Service
        Mono<Collection<Country>> response = webClient
                .get()
                .uri(COUNTRY_SERVICE_ROOT_URI)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<>() {
                });
        Collection<Country> countries = response.block();

        assert countries != null;
        List<Country> all = countries.stream().toList();

        model.addAttribute("methodName", "calling from getCountries()");
        model.addAttribute("countries", all);

        // The return name must match the name of countries.html
        return "countries";
    }
}
