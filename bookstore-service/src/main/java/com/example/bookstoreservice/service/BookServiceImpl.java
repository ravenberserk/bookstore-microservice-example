package com.example.bookstoreservice.service;

import com.example.bookstoreservice.domain.Book;
import com.example.bookstoreservice.repository.BookRepository;
import com.example.bookstoreservice.source.BookRegistrationSource;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@EnableBinding(BookRegistrationSource.class)
@Log4j2
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookRegistrationSource bookRegistrationSource;

    @Override
    public Book create(String title, String summary) {
        log.info("Se crea un nuevo libro con los siguientes datos -> Titulo: {}, Desc: {}", title, summary);
        Book createdBook = bookRepository.save(new Book(title, summary));
        bookRegistrationSource.registerNewBook().send(MessageBuilder.withPayload(createdBook).build());
        return createdBook;
    }

    @Override
    public Optional<Book> findBook(String bookId) {
        log.info("Se va a buscar el libro con ID: {}", bookId);
        Optional<Book> searchedBook = bookRepository.findById(bookId);
        return searchedBook;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}
