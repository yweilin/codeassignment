package fi.assignment.countryservice.controller;

import fi.assignment.countryservice.model.Country;
import fi.assignment.countryservice.service.CountryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collection;

/**
 * This class handles HTTP requests of country data.
 */
@RestController
public class CountryController {
    private final CountryService countryService;

    public CountryController(@Autowired final CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public Collection<Country> getCountries() {
        return countryService.getCountries();
    }

    @GetMapping("/countries/{name}")
    public Country getCountry(@PathVariable final String name) {
        Country country = countryService.getCountry(name);
        if (country == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return country;
    }

    @PostMapping("/countries")
    public void add(@RequestBody @Valid Country name) {
        countryService.add(name);
    }

    @DeleteMapping("/countries")
    public void delete(@RequestBody Country country) {
        Country removed = countryService.deleteCountry(country);
        if (removed == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/countries/{name}")
    public void delete(@PathVariable String name) {
        Country removed = countryService.deleteCountry(name);
        if (removed == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
