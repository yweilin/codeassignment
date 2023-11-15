# Country View Service

## About the Country View Service
The *Country View Service* is the service to fetch country data via *Country Service* 
and display the data onto web page.

The *Country View Service* can be run on localhost at port 8082.

## Country View Service API Documentation
The local host of *Country View Service* : http://localhost:8082

| API                         | DESCRIPTION             |
|:----------------------------|:------------------------|
| GET: /countries             | View all countries      |
| GET: /countries?name={name} | View a specific country |

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

#### How to start Country Service by CLT
```
java -jar CountryService-1.0.0-SNAPSHOT.jar
```

#### How to start Country View Service by CLT
```
java -jar CountryViewService-1.0.0-SNAPSHOT.jar
```

## How to use?

* Start *Country Service* and *Country View Service* servers

  ```
  java -jar CountryService-1.0.0-SNAPSHOT.jar
  java -jar CountryViewService-1.0.0-SNAPSHOT.jar
  ```
  
* Go to browser with localhost and try out
  * View home page: http://localhost:8082
  * View all countries: http://localhost:8082/countries
  * View a specific country: http://localhost:8082/country?name=China
