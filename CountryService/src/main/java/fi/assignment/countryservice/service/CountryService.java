package fi.assignment.countryservice.service;

import fi.assignment.countryservice.model.Country;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class holds mock country data and provide data to {@code CountryController}.
 */
@Service
public class CountryService {

    /**
     * The mock database of country data.
     */
    private final Map<String, Country> countries = new HashMap<>() {{
        put("Finland", new Country("Finland", "FI", "Helsinki", "https://flagcdn.com/w320/fi.png", 5530719));
        put("Hungary", new Country("Hungary", "HU", "Budapest", "https://flagcdn.com/w320/hu.png", 9749763));
        put("China", new Country("China", "CN", "Beijing", "https://flagcdn.com/w320/cn.png", 1402112000));
        put("Denmark", new Country("Denmark", "DK", "Copenhagen", "https://flagcdn.com/w320/dk.png", 5831404));
        put("Norway", new Country("Norway", "NO", "Oslo", "https://flagcdn.com/w320/no.png", 5379475));
        put("Sweden", new Country("Sweden", "SE", "Stockholm", "https://flagcdn.com/w320/se.png", 10353442));
        put("Switzerland", new Country("Switzerland", "CH", "Bern", "https://flagcdn.com/w320/ch.png", 8636896));
        put("Japan", new Country("Japan", "JP", "Tokyo", "https://flagcdn.com/w320/jp.png", 100800));
        put("Austria", new Country("Austria", "AT", "Vienna", "https://flagcdn.com/w320/at.png", 8917205));
//        put("Australia", new Country("Australia", "AU", "Canberra", "https://flagcdn.com/w320/au.png", 25687041));
    }};

    public Collection<Country> getCountries() {
        return countries.values();
    }

    public Country getCountry(final String name) {
        return countries.get(name);
    }

    public void add(final Country country) {
        countries.put(country.getName(), country);
    }

    public Country deleteCountry(Country country) {
        return countries.remove(country.getName());
    }

    public Country deleteCountry(String name) {
        return countries.remove(name);
    }
}
