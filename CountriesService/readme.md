# Countries Service

## About the CountriesService
The *CountriesService* is the service to fetch country data via *REST Countries* service.

The *CountriesService* can be run on localhost at port 8083.

## CountriesService API Documentation
The local host of *CountriesService* : http://localhost:8083

| API                   | DESCRIPTION                         |
|:----------------------|:------------------------------------|
| GET /countries        | Retrieve data of all countries      |
| GET /countries/{name} | Retrieve data of a specific country |

## How to build and start service?
IntelliJ IDEA or CLT(Command Line Tool) is used to build application, start server or run tests.

#### How to build application by CLT
```
mvn clean install -DskipTest=true
```

#### How to start CountriesService by CLT
```
java -jar CountriesService-1.0.0-SNAPSHOT.jar
```

## How to use?

* Start *CountriesService* server

  ```
  java -jar CountriesService-1.0.0-SNAPSHOT.jar
  ```

* Go to browser with localhost and try out
    * Retrieve all countries: http://localhost:8083/countries
    * Retrieve a specific country: http://localhost:8083/countries/Finland
