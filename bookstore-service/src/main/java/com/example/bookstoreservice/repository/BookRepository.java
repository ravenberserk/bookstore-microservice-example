package com.example.bookstoreservice.repository;

import com.example.bookstoreservice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, String> {

}
