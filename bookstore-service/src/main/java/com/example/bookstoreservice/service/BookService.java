package com.example.bookstoreservice.service;

import com.example.bookstoreservice.domain.Book;

import java.util.Optional;

public interface BookService {

    public Book create(String title, String summary);

    public Optional<Book> findBook(String bookId);

    public Iterable<Book> findAll();

}
