# Country Service

## About the CountryService
The *CountryService* is the service to retrieve data for single or multiple countries. 
The data includes country name, country code, population and URI of country flag.

The information of all country can be viewed in web page through a localhost.
Those country data is fetched via RESTful API of *REST Countries* service.

The *CountryService* can be run on localhost at port 8081.

## CountryService API Documentation
The local host of *CountryService* : http://localhost:8081

| API                      | DESCRIPTION                             |
|:-------------------------|:----------------------------------------|
| GET    /countries        | Get data of all countries               |
| GET    /countries/{name} | Get data of a country with given name   |
| POST   /countries        | Add a country with payload of a country |
| DELETE /countries/{name} | Delete a country with given name        | 

## How to build and start service?
IntelliJ IDEA or CLT(Command Line Tool) is used to build application, start server or run tests.

#### How to build application by CLT
```
mvn clean install -DskipTest=true
```

#### How to start CountryService server by CLT
```
java -jar CountryService-1.0.0-SNAPSHOT.jar
```

#### How to run tests by CLT
```
mvn test
```
## How to use?

* Start the *CountryService* server
    ```
    java -jar CountryService-1.0.0-SNAPSHOT.jar
    ```
  
* Go to browser with localhost and try out
   * Fetch data of all countries: http://localhost:8081/countries
   * Fetch data of a specific country: http://localhost:8081/countries/Finland
   * Add a country to mock DB: http://localhost:8081/countries
   * Delete a country from mock DB: http://localhost:8081/countries/Finland
   * View all countries: http://localhost:8081
