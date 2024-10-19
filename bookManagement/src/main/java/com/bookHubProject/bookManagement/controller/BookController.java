package com.bookHubProject.bookManagement.controller;

import com.bookHubProject.bookManagement.bean.Book;
import com.bookHubProject.bookManagement.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    Configuration book;

    @GetMapping("/book")
    public Book getBooks(){
        return new Book(book.getName(), book.getAuthor(), book.getPrice());
    }
}
