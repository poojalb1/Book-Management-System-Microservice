package com.bookHubProject.bookManagement.controller;

import com.bookHubProject.bookManagement.bean.TestBook;
import com.bookHubProject.bookManagement.configuration.Configuration;
import com.bookHubProject.bookManagement.entity.Book;
import com.bookHubProject.bookManagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    Configuration book;

    @Autowired
    BookService bookService;

    @GetMapping("/testBookConnection")
    public TestBook test() {
        return new TestBook(book.getName(), book.getAuthor(), book.getPrice());
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Optional<Book> getBook = bookService.findById(book.getBookId());
        if (getBook.isPresent())
            return ResponseEntity.ok(bookService.addBook(book));
        else return (ResponseEntity<Book>) ResponseEntity.notFound();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id) {
        Optional<Book> getBook = bookService.findById(id);
        if (getBook.isPresent())
            return ResponseEntity.ok(getBook.get());
        else return (ResponseEntity<Book>) ResponseEntity.notFound();
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> getBook = bookService.findAll();
        return ResponseEntity.ok(getBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBooks(@PathVariable Integer id) {
        Optional<Book> getBook = bookService.findById(id);
        getBook.ifPresent(value -> bookService.delete(value));
    }


}
