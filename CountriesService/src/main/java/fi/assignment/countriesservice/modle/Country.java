package fi.assignment.countriesservice.modle;

import java.util.ArrayList;

/**
 * This class represents a country based on Json format of REST Countries version 3.1.
 */
public class Country {
    public Name name;
    public ArrayList<String> tld;
    public String cca2;
    public String ccn3;
    public String cca3;
    public String cioc;
    public boolean independent;
    public String status;
    public boolean unMember;
    public Currencies currencies;
    public Idd idd;
    public ArrayList<String> capital;
    public ArrayList<String> altSpellings;
    public String region;
    public String subregion;
    public Languages languages;
    public Translations translations;
    public ArrayList<Integer> latlng;
    public boolean landlocked;
    public ArrayList<String> borders;
    public int area;
    public Demonyms demonyms;
    public String flag;
    public Maps maps;
    public int population;
    public Gini gini;
    public String fifa;
    public Car car;
    public ArrayList<String> timezones;
    public ArrayList<String> continents;
    public Flags flags;
    public CoatOfArms coatOfArms;
    public String startOfWeek;
    public CapitalInfo capitalInfo;
    public PostalCode postalCode;
}
