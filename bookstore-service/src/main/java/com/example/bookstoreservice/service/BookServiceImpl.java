package com.example.bookstoreservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookstoreservice.domain.Book;
import com.example.bookstoreservice.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(String title, String summary) {
	return bookRepository.save(new Book(title, summary));
    }

    @Override
    public Optional<Book> findBook(String bookId) {
	return bookRepository.findById(bookId);
    }

    @Override
    public Iterable<Book> findAll() {
	return bookRepository.findAll();
    }

}
