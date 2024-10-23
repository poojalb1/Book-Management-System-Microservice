package com.bookHubProject.orderManagement.proxy;

import com.bookHubProject.orderManagement.entity.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-management", url = "localhost:8000")
public interface BookManagementProxy {

    @GetMapping("/book/{id}")
    public BookDTO retrieveBookInfo(
            @PathVariable("id") Integer bookId
    );
}

