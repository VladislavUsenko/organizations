# Spring Boot REST example

restful API service for organizations and merchants

## Service contains

* Spring Boot 2.5.5
* Spring Framework
* Spring Data JPA
* Spring Security
* Swagger UI
* Flyway
* PostgreSQL

## Prerequisites for running the service

* [Java 11](https://www.oracle.com/java/technologies/downloads/#)
* [Maven 3](https://maven.apache.org/install.html)
* [PostgreSQL 14](https://www.postgresql.org/download/)

## Run service

### download repository
```shell
git clone https://github.com/VladislavUsenko/organizations.git
```

set database parameters in `resources/application.yml`

```yaml
spring:
  datasource: 
    url: #set your database url
    username: #set your user
    password: #set user's pass
```
### build service

```shell
cd your\service\directory
mvn package
```

### run jar file 

```shell
java -jar target\organizations-0.0.1.jar
```
