# Country Service

## About the Country Service
The *Country Service* is the service to retrieve data for single or multiple countries. 
The data includes country name, country code, population and URI of country flag.

The information of all country can be viewed in web page through a localhost.
Those country data is fetched via RESTful API of *REST Countries* service.

The *Country Service* can be run on localhost at port 8081.

## Outputs of the Country Service

Single county:
```json
{
    "name": "Finland",
    "countryCode": "FI",
    "capital": "Helsinki",
    "flagFileUrl": "https://flagcdn.com/w320/fi.png",
    "population": 5530719
}
```

Multiple countries:
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

## Country Service API Documentation
The local host of *Country Service* : http://localhost:8081

| API                       | DESCRIPTION                             |
|:--------------------------|:----------------------------------------|
| GET:    /countries        | Get data of all countries               |
| GET:    /countries/{name} | Get data of a country with given name   |
| POST:   /countries        | Add a country with payload of a country |
| DELETE: /countries/{name} | Delete a country with given name        | 

## Project Setup
### Requirement
* Java 17 + JDK
* Spring Boot version 3.1.5, current newest stable version
* Apache Maven version 3.9.5

### Development Tools
* IntelliJ IDEA
* Postman
* GitHub

## How to build and start service?
IntelliJ IDEA or CLT(Command Line Tool) is used to build application, start server or run tests.

#### How to build application by CLT
```
mvn clean install -DskipTest=true
```

#### How to start Country Service server by CLT
```
java -jar CountryService-1.0.0-SNAPSHOT.jar
```

#### How to run tests by CLT
```
mvn test
```
## How to use?

* Start the *Country Service* server
    ```
    java -jar CountryService-1.0.0-SNAPSHOT.jar
    ```
  
* Go to browser with localhost and try out
   * Fetch data of all countries: http://localhost:8081/countries
   * Fetch data of a specific country: http://localhost:8081/countries/Finland
   * Add a country to mock DB: http://localhost:8081/countries
   * Delete a country from mock DB: http://localhost:8081/countries/Finland
   * View all countries: http://localhost:8081

## Development Details

### Study requirement

#### Reference
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

### Structure Outline
Serving Web Content with *Spring MVC*.
Reactive microservices with *Spring WebFlux*.

```
.
├── pom.xml
├── readme.md
└── src
    ├── main
    │   ├── java
    │   │   └── fi
    │   │       └── assignment
    │   │           └── countryservice
    │   │               ├── CountryServiceApplication.java
    │   │               ├── controller
    │   │               │   └── CountryController.java
    │   │               ├── model
    │   │               │   └── Country.java
    │   │               └── service
    │   │                   └── CountryService.java
    │   └── resources
    │       ├── application.properties
    │       └── static
    │           ├── country.css
    │           ├── country.js
    │           └── index.html
    └── test
        └── java
            └── fi
                └── assignment
                    └── countryservice
                        ├── CountryServiceApplicationTests.java
                        └── controller
                            └── CountryControllerTest.java
```

### Implementation steps

1. Setup working environment
2. Make project skeleton
3. Implement *Country Service* with mock country data
4. Manual and unit test the implemented service
5. Implement *Country View Service* which uses *Country Service*
6. Display all countries using real data provided by *REST Countries*, the JavaScript way
7. Make the services reactive with *Spring WebFlux*
8. Display all countries using mock data, the Microservice way
9. Make *Countries Services* and *Countries View Service* using real country data
10. Display real country data on browser

### Task Checklist
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
