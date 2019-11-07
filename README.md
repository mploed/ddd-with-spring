# ddd-with-spring

<div align="center">

[![Build Status](https://travis-ci.org/mploed/ddd-with-spring.svg?branch=master)](https://travis-ci.org/mploed/ddd-with-spring)

</div>

This repository aims at showcasing a way how you could implement various aspects from Domain-driven Design with the
Spring ecosystem. It is also the demo project for my conference talk "Implementing Domain-driven Design with the Spring 
ecosystem".

## Which DDD aspects are covered?
The focus of the demo project are Aggregates, event-based communication and bounded contests. The complete list is:

- Aggregates
- Event-based communication with
    - a message broker (RabbitMQ)
    - HTTP Feeds
    - Spring Application Events
- Architectural styles
    - Hexagonal Architecture
    - CRUD
    - Query-driven (not yet implemented properly)
    
## Which Spring Technologies are being used?

The project uses the following Spring technologies:

- Spring Framework Core
- Spring MVC
- Spring Boot
- Spring Cloud Stream 
- Spring Data JPA

## Prerequisites and getting started

In order to run the application you need to have Docker and docker-compose installed on your machine.

When you have docker up and running you need to perform the following steps on the command line:

1. ./mvnw clean package
2. docker-compose up --build
3. After everything has started you can open http://localhost:8080 in a browser of your choice
