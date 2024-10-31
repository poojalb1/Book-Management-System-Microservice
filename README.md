# Book-Management-System-Microservice
A microservice application for book management, featuring separate services for managing books and handling orders

# Microservices Description
## Config Server<br>

Provides centralized configuration for all microservices.<br>
Uses Spring Cloud Config Server.<br>
## Book-management Service<br>

Provides book CRUD operations.
Integrated with Eureka Discovery.
## Naming Service

Service registry using Netflix Eureka.
Enables service discovery for other microservices.
## Gateway Service

API Gateway for routing requests to appropriate microservices.
Uses Spring Cloud Gateway.
## Order-management Service

Manages orders and their statuses.
Integrated with Eureka Discovery.

# Features
Service Discovery: All microservices register with the Eureka server for easy discovery.
Centralized Configuration: Configurations are managed centrally using the Spring Cloud Config Server.
API Gateway: Spring Cloud Gateway is used for routing and handling cross-cutting concerns like security, monitoring, and resilience.
Circuit Breaker: Circuit breaking capabilities provided by Spring Cloud Circuit Breaker.

# Prerequisites
Java 17 or later
Gradle

# Running the Microservices
Clone the repository

git clone [https://github.com/PramithaMJ/fully-completed-microservices.git](https://github.com/poojalb1/Book-Management-System-Microservice.git)
 OR
Use start_services.bat batch file to run all services.

Ensure all services are configured to register with the Discovery Service.


Each microservice has its configuration properties defined in the application.properties file. The Config Server properties should be specified in a central configuration repository.
