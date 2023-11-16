# Country View Service

## About the CountryViewService
The *CountryViewService* is the service to fetch country data via *CountryService* 
and display the data onto web page.

The *CountryViewService* can be run on localhost at port 8082.

## CountryViewService API Documentation
The local host of *Country View Service* : http://localhost:8082

| API                        | DESCRIPTION             |
|:---------------------------|:------------------------|
| GET /countries             | View all countries      |
| GET /countries?name={name} | View a specific country |

## How to build and start service?
IntelliJ IDEA or CLT(Command Line Tool) is used to build application, start server or run tests.

#### How to build application by CLT
```
mvn clean install -DskipTest=true
```

#### How to start CountryService by CLT
```
java -jar CountryService-1.0.0-SNAPSHOT.jar
```

#### How to start CountryViewService by CLT
```
java -jar CountryViewService-1.0.0-SNAPSHOT.jar
```

## How to use?

* Start *CountryService* and *CountryViewService* servers

  ```
  java -jar CountryService-1.0.0-SNAPSHOT.jar
  java -jar CountryViewService-1.0.0-SNAPSHOT.jar
  ```
  
* Go to browser with localhost and try out
  * View home page: http://localhost:8082
  * View all countries: http://localhost:8082/countries
  * View a specific country: http://localhost:8082/country?name=China
