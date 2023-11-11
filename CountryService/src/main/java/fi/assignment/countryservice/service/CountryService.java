package fi.assignment.countryservice.service;

import fi.assignment.countryservice.mode.Country;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class CountryService {

    private Map<String, Country> countries = new HashMap<>() {{
        put("Finland", new Country("Finland", "FI", "Helsinki", "https://flagcdn.com/w320/fi.png", 5530719));
        put("Hungary", new Country("Hungary", "HU", "Budapest", "https://flagcdn.com/w320/hu.png", 9749763));
        put("China", new Country("China", "CN", "Beijing", "https://flagcdn.com/w320/cn.png", 1402112000));
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

}
