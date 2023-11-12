package fi.assignment.countryservice.model;

import jakarta.validation.constraints.NotNull;

/**
 * This class represents a country.
 */
public class Country {
    @NotNull
    private String name;
    private String countryCode;
    private String capital;
    private String flagFileUrl;
    private int population;

    public Country() {
    }

    public Country(final String name, final String countryCode, final String capital,
                   final String flagFileUrl, final int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.capital = capital;
        this.flagFileUrl = flagFileUrl;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(final String capital) {
        this.capital = capital;
    }

    public String getFlagFileUrl() {
        return flagFileUrl;
    }

    public void setFlagFileUrl(final String flagFileUrl) {
        this.flagFileUrl = flagFileUrl;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(final int population) {
        this.population = population;
    }
}
