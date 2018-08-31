package com.example.bookstoreservice.service;

import java.util.Optional;

import com.example.bookstoreservice.domain.Book;

public interface BookService {

	public Book create(String title, String summary);
	
	public Optional<Book> findBook(String bookId);
	
	public Iterable<Book> findAll();
	
}
