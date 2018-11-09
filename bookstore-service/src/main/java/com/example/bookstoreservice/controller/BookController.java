package com.example.bookstoreservice.controller;

import com.example.bookstoreservice.domain.Book;
import com.example.bookstoreservice.service.BookService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;


@RestController
public class BookController {

    private static Log log = LogFactory.getLog(BookController.class);

    @Autowired
    private BookService bookService;

    @PostMapping(path = "/")
    @PreAuthorize("#oauth2.hasScope('server')")
    public ResponseEntity<Book> createNewBook(@Valid @RequestBody Book book) {
        log.info("Se va a crear un nuevo libro con los datos: " + book);
        return new ResponseEntity<>(bookService.create(book.getTitle(), book.getSummary()), HttpStatus.CREATED);
    }

    @GetMapping(path = "/")
    @PreAuthorize("#oauth2.hasScope('server')")
    public ResponseEntity<Iterable<Book>> findAllBooks() {
        log.info("Se recuperan todos los libros.");
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") String bookId) {
        log.info("Se busca el libro con Id: " + bookId);
        return new ResponseEntity<>(bookService.findBook(bookId).orElseThrow(NoSuchElementException::new),
                HttpStatus.OK);
    }

}
