# Book-Management-System-Microservice
A microservice application for book management, featuring separate services for managing books and handling orders

# Microservices Description
## Config Server<br>

Provides centralized configuration for all microservices.<br>
Uses Spring Cloud Config Server.<br>
## Book-management Service<br>

Provides book CRUD operations.<br>
Integrated with Eureka Discovery.<br>
## Naming Service<br>

Service registry using Netflix Eureka.<br>
Enables service discovery for other microservices.<br>
## Gateway Service<br>

API Gateway for routing requests to appropriate microservices.<br>
Uses Spring Cloud Gateway.<br>
## Order-management Service<br>

Manages orders and their statuses.<br>
Integrated with Eureka Discovery.<br>

# Features
Service Discovery: All microservices register with the Eureka server for easy discovery.<br>
Centralized Configuration: Configurations are managed centrally using the Spring Cloud Config Server.<br>
API Gateway: Spring Cloud Gateway is used for routing and handling cross-cutting concerns like security, monitoring, and resilience.<br>
Circuit Breaker: Circuit breaking capabilities provided by Spring Cloud Circuit Breaker.<br>

# Prerequisites
Java 17 or later<br>
Gradle<br>

# Running the Microservices
Clone the repository

git clone [https://github.com/PramithaMJ/fully-completed-microservices.git](https://github.com/poojalb1/Book-Management-System-Microservice.git)<br>
 
Use start_services.bat batch file to run all services.<br>

Ensure all services are configured to register with the Discovery Service.<br>


Each microservice has its configuration properties defined in the application.properties file. The Config Server properties should be specified in a central configuration repository.
