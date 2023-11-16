# Countries View Service

## About the CountriesViewService
The *CountriesViewService* is the service to fetch real country data via *CountriesService*
and display the data onto web page.

The *CountriesViewService* can be run on localhost at port 8084.

## CountriesViewService API Documentation
The local host of *CountriesViewService* : http://localhost:8084

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

#### How to start CountriesService by CLT
```
java -jar CountriesViewService-1.0.0-SNAPSHOT.jar

```

#### How to start CountriesViewService by CLT
```
java -jar CountriesViewService-1.0.0-SNAPSHOT.jar

```

## How to use?

* Start *Country Service* and *CountriesViewService* servers

  ```
  java -jar CountriesService-1.0.0-SNAPSHOT.jar
  java -jar CountriesViewService-1.0.0-SNAPSHOT.jar

  ```

* Go to browser with localhost and try out
    * View home page: http://localhost:8084
    * View all countries: http://localhost:8084/countries
    * View a specific country: http://localhost:8084/country?name=China