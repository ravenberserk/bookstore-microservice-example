package com.example.bookstoreservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.bookstoreservice.domain.Book;

public interface BookRepository extends CrudRepository<Book, String> {

}
