package com.example.bookstoreservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.example.bookstoreservice.domain.Book;
import com.example.bookstoreservice.repository.BookRepository;
import com.example.bookstoreservice.source.BookRegistrationSource;

@Service
@EnableBinding(BookRegistrationSource.class)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookRegistrationSource bookRegistrationSource;

    @Override
    public Book create(String title, String summary) {
	Book createdBook = bookRepository.save(new Book(title, summary));
	bookRegistrationSource.registerNewBook().send(MessageBuilder.withPayload(createdBook).build());
	return createdBook;
    }

    @Override
    public Optional<Book> findBook(String bookId) {
	Optional<Book> searchedBook = bookRepository.findById(bookId);
	// TODO: Registrar en el log la lectura de un libro.
	return searchedBook;
    }

    @Override
    public Iterable<Book> findAll() {
	return bookRepository.findAll();
    }

}
