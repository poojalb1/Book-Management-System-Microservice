package com.bookHubProject.orderManagement.proxy;

import com.bookHubProject.orderManagement.entity.dto.BookDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "book-management")
public interface BookManagementProxy {

    @GetMapping("/book/{id}")
    @CircuitBreaker(name = "book-management-proxy", fallbackMethod = "fallbackBookInfo")
    BookDTO retrieveBookInfo(
            @PathVariable("id") Integer bookId
    );

    @PutMapping("/book")
    BookDTO updateBookInfo(
            @RequestBody BookDTO book
    );

    public default BookDTO fallbackBookInfo(Integer bookId, Throwable throwable) {
        // This fallback method is invoked when the circuit breaker is triggered.
        // The circuit breaker is useful in conjunction with Eureka service discovery for the following reasons:
        //
        // - **Transient Failures**: It prevents excessive requests to a service that is temporarily unavailable
        //   (e.g., due to network issues), reducing potential strain on both the client and server.
        //
        // - **Load Management**: By limiting calls during known service outages, it helps protect your
        //   infrastructure from being overwhelmed during periods of downtime.
        //
        // In this case, we provide a default BookDTO response to inform users that the service is currently
        // unavailable.
        BookDTO fallbackBook = new BookDTO();
        fallbackBook.setBookId(bookId);
        fallbackBook.setBookName("Service Unavailable");
        fallbackBook.setBookAuthor("Unknown");
        return fallbackBook;
    }
}

