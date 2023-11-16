# Code Assignment

## About the assignment

Implement a microservice *COUNTRY SERVICE* which provides a list of countries and, in addition, provides more detailed information per country.

## Assignment Requirement

1. Use spring-boot 
2. Use maven
3. Use best practices and microservice approach
4. Implement the following *REST API* with spring-boot

   ```
      GET /countries/
   ```
   ```json
      {
         "countries": [
            {
               "name": "Finland",
               "country_code": "FI"
            },
            {
               "name": "Hungary",
               "country_code": "HU"
            }
         ]
      }   
   ```
   ```
   GET /countries/{name}
   ```
   ```json
      {
         "name": "Finland",
         "country_code": "FI",
         "capital": "Helsinki",
         "population": 5491817, 
         "flag_file_url": "<url to the flag file>"
      }
   ```
       
5. Country service must fetch the relevant information for countries from some other service
    * You could use for example the following https://restcountries.com/
6. Test the implementation as well as it's needed from your perspective
7. All the implementations must be runnable locally with our own computer. Write needed instructions to *README.md* file.
8. Publish all sources code and relevant files in GitHub or similar service and send the link to the repo so that the implementation can be reviewed.

You get bonus points if:

- you use and understand [Reactor](https://www.baeldung.com/reactor-core)
- you create a separate web application which utilizes the created REST API and shows the relevant country information in a browser

## Assignment Project
### Project Setup
#### Requirement
* Java 17 + JDK
* Spring Boot version 3.1.5, current newest stable version
* Apache Maven version 3.9.5

#### Development Tools
* IntelliJ IDEA
* Postman
* GitHub

### Project Structure

```
.
├── CountriesService
├── CountriesViewService
├── CountryService
├── CountryViewService
└── readme.md
```
* The *CountriesService* and *CountriesViewService* microservices 
  * Utilize real country data retried from *REST Countries Service*
* The *CountryService* and *CountryViewService* microservices 
  * Use mocking country data

### Project Outcome
#### Microservices Port
The localhost: http://localhost:[port]
- *CountryService* port: 8081
- *CountryViewService* port: 8082
- *CountriesService* port: 8083
- *CountriesViewService* port: 8084

#### Technical details
* Microservice approach is used
* Reactive programming using *Spring WebFlux*
* For either real or mocking country data:
  * Single or multiple country data can be fetched
  * Single or multiple country data can be viewed via browse

    ***Single county:***

    ```json
    {
        "name": "Finland",
        "countryCode": "FI",
        "capital": "Helsinki",
        "flagFileUrl": "https://flagcdn.com/w320/fi.png",
        "population": 5530719
    }
    ```

    ***Multiple countries:***

    ```json
    [
        {
            "name": "Hungary",
            "countryCode": "HU",
            "capital": "Budapest",
            "flagFileUrl": "https://flagcdn.com/w320/hu.png",
            "population": 9749763
        },
        {
            "name": "China",
            "countryCode": "CN",
            "capital": "Beijing",
            "flagFileUrl": "https://flagcdn.com/w320/cn.png",
            "population": 1402112000
        },
        {
            "name": "Finland",
            "countryCode": "FI",
            "capital": "Helsinki",
            "flagFileUrl": "https://flagcdn.com/w320/fi.png",
            "population": 5530719
        }
    ]
    ```

### Project Development

####  Study requirement
*Reference*
* [REST Countries Documentation](https://restcountries.com/)
* [REST Countries API version 2.0](https://restcountries.com/v2/all)
* [REST Countries API version 3.1](https://restcountries.com/v3.1/all)
* [Spring Boot 3.1.5](https://spring.io/projects/spring-boot/)
* [Spring Initializr](https://start.spring.io/)
* [Reactive](https://spring.io/reactive)
* [React Core](https://docs.spring.io/spring-framework/reference/web/webflux/reactive-spring.html)
* [Spring WebFlux](https://docs.spring.io/spring-framework/reference/web/webflux.html)
* [Spring 5 WebClient](https://www.baeldung.com/spring-5-webclient)
* [Get List of JSON Objects with WebClient](https://www.baeldung.com/spring-webclient-json-list)
* [Testing the Web Layer](https://spring.io/guides/gs/testing-web/)
* [Bootstrap v5.3](https://getbootstrap.com/docs/5.3/getting-started/introduction/)
* [Thymeleaf v3.1](https://www.thymeleaf.org/documentation.html)

#### Design
* Serving content using *Spring MVC*
* Interacting microservices using *Spring WebFlux*
* Styling HTML elements using *Bootstrap* and *Thymeleaf*

#### Implementation steps

1. Setup working environment
2. Make project skeleton
3. Implement *CountryService* with mock country data
4. Manual and unit test the implemented service
5. Implement *CountryViewService* which uses *Country Service*
6. Display all countries using real data provided by *REST Countries*, the JavaScript way
7. Make the services reactive with *Spring WebFlux*
8. Display all countries using mock data, the Microservice way
9. Make *CountriesServices* and *CountriesViewService* using real country data
10. Display real country data on browser

#### Task Checklist
- [x] Project skeleton, 10-11-2023
- [x] *Country Service* with mock country data, 11-11-2023
- [x] Mocking tests the *Country Service*, 11-11-2023
- [x] Manual tests using *Postman*, 11-11-2023
- [x] View all countries using JavaScript via REST Countries API, 12-11-2023
- [x] *Country View Service* using *Country Service*, 15-11-2023
- [x] View all countries using mock country data, the Microservice way, 15-11-2023
- [x] Real country data can be fetched and displayed, 16-11-2023
- [x] Documentation and code clean up, 16-11-2023
- [x] Final test, 16-11-2023
- [x] Main *readme.md*, 17-11-2023
