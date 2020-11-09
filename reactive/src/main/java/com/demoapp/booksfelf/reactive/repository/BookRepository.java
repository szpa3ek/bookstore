package com.demoapp.booksfelf.reactive.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.awt.print.Book;

public interface BookRepository extends ReactiveCrudRepository<Book,Long> {
}
