package com.bookHubProject.api_gateway.configuration;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {


    /**
     * Configures the routing for the Spring Cloud Gateway.
     * <p>
     * This method creates a route locator that defines how incoming requests
     * should be directed to specific services. The routing is based on the
     * request paths. The following routes are configured:
     * <p>
     * 1. **GET Request to `/get`:**
     * - This route forwards GET requests made to the path `/get`
     * to the external service located at `http://httpbin.org:80`.
     * <p>
     * 2. **Requests to `/book**`:**
     * - Requests matching the path pattern `/book**` (which includes
     * any sub-paths under `/book`, such as `/book/123` or `/book/create`)
     * are routed to a service registered with Eureka under the name
     * `BOOK-MANAGEMENT`.
     * - Load balancing is automatically handled by Spring Cloud's
     * built-in load balancer. This means that if there are multiple
     * instances of the `BOOK-MANAGEMENT` service, the requests will
     * be distributed among them, ensuring efficient resource use
     * and increased reliability.
     * <p>
     * 3. **Requests to `/order**`:**
     * - Similar to the `/book**` route, requests that match the path
     * pattern `/order**` are routed to the service registered with
     * Eureka under the name `0RDER-MANAGEMENT`.
     * - Load balancing is also applied for this service.
     * <p>
     * The use of the `lb://` prefix indicates that the routes should
     * utilize the service discovery mechanism provided by Eureka to
     * find and route requests to the appropriate service instances
     * while balancing the load across them.
     *
     * @param builder The RouteLocatorBuilder used to build the route locator.
     * @return A RouteLocator containing the defined routes.
     */

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/get")
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/book**")
                        .uri("lb://BOOK-MANAGEMENT"))
                .route(p -> p.path("/order**")
                        .uri("lb://ORDER-MANAGEMENT"))
                .build();
    }
}
