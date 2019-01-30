package com.example.bookstoreservice.controller;

import com.example.bookstoreservice.domain.Book;
import com.example.bookstoreservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/")
    @PreAuthorize("#oauth2.hasScope('server')")
    public ResponseEntity<Book> createNewBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.create(book.getTitle(), book.getSummary()), HttpStatus.CREATED);
    }

    @GetMapping(path = "/")
    @PreAuthorize("#oauth2.hasScope('server')")
    public ResponseEntity<Iterable<Book>> findAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") String bookId) {
        return new ResponseEntity<>(bookService.findBook(bookId).orElseThrow(NoSuchElementException::new),
                                    HttpStatus.OK);
    }

}
