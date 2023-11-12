/**
 * Fetch counties using REST Counties API version 3.1 and display the countries onto web page.
 */
const loadCountries = () => {
    fetch('https://restcountries.com/v3.1/all?fields=name,flags,population,capital,cca2')
        .then(response => response.json())
        // .then(data => console.log(data))
        .then(data => displayCountries(data));
}

/**
 * Display the country data onto web page.
 *
 * @param countries the input counties in Json format
 */
const displayCountries = countries => {
    // console.log(countries);
    const countriesHTML = countries.map(country => getCountry(country));
    const container = document.getElementById('countries');
    container.innerHTML = countriesHTML.join(' ');
}

/**
 * Get country data in HTML format.
 *
 * @param country the country in Json format
 * @returns {`
 <div class="country-div">
 <img src="${*}" alt="${string}"/>
 <h2>${*}</h2>
 <hr>
 <h4>Capital: ${*}</h4>
 <h4>Country code: ${*}</h4>
 <h4>Population: ${*}</h4>
 </div>
 `}
 */
const getCountry = (country) => {
    console.log(country);
    return `
        <div class="country-div">
        <img src="${country.flags.png}" alt="${country.flags.alt}"/>
        <h2>${country.name.common}</h2>
        <hr>
        <h4>Capital: ${country.capital}</h4>
        <h4>Country code: ${country.cca2}</h4>
        <h4>Population: ${country.population}</h4>
        </div>
    `
}

/**
 * Calling the function to get output onto web page.
 */
loadCountries()