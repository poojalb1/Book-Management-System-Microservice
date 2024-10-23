package com.bookHubProject.orderManagement.proxy;

import com.bookHubProject.orderManagement.entity.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "book-management", url = "localhost:8081")
public interface BookManagementProxy {

    @GetMapping("/book/{id}")
    BookDTO retrieveBookInfo(
            @PathVariable("id") Integer bookId
    );

    @PutMapping("/book")
    BookDTO updateBookInfo(
            @RequestBody BookDTO book
    );
}

