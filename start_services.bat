@echo off

rem Start Spring Cloud Config Server
start cmd /k "title Spring Cloud Config Server && cd D:\Book-Management-System-Microservice\spring-cloud-config-server && gradlew.bat bootRun"

rem Start Eureka Naming Server
start cmd /k "title Eureka Naming Server && cd D:\Book-Management-System-Microservice\naming-server && gradlew.bat bootRun"

rem Start API Gateway
start cmd /k "title API Gateway && cd D:\Book-Management-System-Microservice\api-gateway && gradlew.bat bootRun"

rem Optional: Start Book Management App
start cmd /k "title Book Management App && cd D:\Book-Management-System-Microservice\bookManagement && gradlew.bat bootRun"

rem Optional: Start Order Management App
start cmd /k "title Order Management App && cd D:\Book-Management-System-Microservice\orderManagement && gradlew.bat bootRun"

echo All services are starting...
