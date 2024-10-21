package com.bookHubProject.bookManagement.service;

import com.bookHubProject.bookManagement.Repository.BookRepository;
import com.bookHubProject.bookManagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepo;

    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    public Optional<Book> findById(Integer id) {
        return bookRepo.findById(id);
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public void delete(Book book) {
        bookRepo.delete(book);
    }
}
