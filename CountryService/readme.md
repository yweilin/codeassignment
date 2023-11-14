# Country Service

## About the Country Service
The *Country Service* is the service to retrieve data for single or multiple countries. 
The data includes country name, country code, population and URI of country flag.

The information of all country can be viewed in web page through a localhost.
Those country data is fetched via RESTful API of REST Countries service.

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
The local host of Country Service : http://localhost:8081

| API                        | DESCRIPTION                             |
|:---------------------------|:----------------------------------------|
| GET:    /countries         | Get data of all countries               |
| GET:    /countries/{name}  | Get data of a country with given name   |
| POST:   /countries         | Add a country with payload of a country |
| DELETE: /countries/{name}  | Delete a country with given name        |

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
java -jar CountryService-0.0.1-SNAPSHOT.jar
```

#### How to run tests by CLT
```
mvn test
```
## How to use?

* Start the service with localhost
* Go to browser and try out
   * Fetch data of all countries: http://localhost:8081/countries
   * Fetch data of a specific country: http://localhost:8081/countries/Finland
   * View all countries: http://localhost:8081/

## Development Details

### Study requirement

#### Reference
* [REST Countries Documentation](https://restcountries.com/)
* [REST Countries API version 2.0](https://restcountries.com/v2/all)
* [REST Countries API version 3.1](https://restcountries.com/v3.1/all)
* [Spring Boot 3.1.5](https://spring.io/projects/spring-boot/)
* [Spring initializr](https://start.spring.io/)
* [Spring Quickstart Guide](https://spring.io/quickstart/)
* [Spring 5 WebClient](https://www.baeldung.com/spring-5-webclient)
* [Get List of JSON Objects with WebClient](https://www.baeldung.com/spring-webclient-json-list)
* [Testing the Web Layer](https://spring.io/guides/gs/testing-web/)
* [React Core](https://www.baeldung.com/reactor-core)
* [Bootstrap v5.3](https://getbootstrap.com/docs/5.3/getting-started/introduction/)
* [Thymeleaf v3.1](https://www.thymeleaf.org/documentation.html)

### Outline implementation structure
Serving Web Content with Spring MVC.
1. Country Service provides data about countries
   1. CountryController.class
   2. CountryService.class
   3. Country.class
   4. CountryServiceApplication.class
2. Country View Service fetches the data using Country Service and provide view
   1. CountryViewController.class
   2. CountryViewApplication.class

### Implementation steps

1. Setup working environment
2. Make project skeleton
3. Implement Country Service with mock country data
4. Test the implemented service
5. Implement Country View Service which uses Country Service
6. View all countries using data provided by REST Countries, the JavaScript way
7. Migrate the Country Service to using data from REST Countries

### Task Checklist
- [x] Project skeleton, 10-11-2023
- [x] Country Service with mock country data, 11-11-2023
- [x] Mocking tests the Country Service, 11-11-2023
- [x] Manual tests using Postman, 11-11-2023
- [x] View all countries using JavaScript via REST Countries API, 12-11-2023
- [x] Country View Service using Country Service, 15-11-2023
- [ ] Migrate Country Service to use REST Countries API
- [ ] Documentation and code clean up
