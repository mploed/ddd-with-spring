# ddd-with-spring

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
