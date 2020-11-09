package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Book;
import com.demoapp.bookshelf.persistence.model.Person;
import com.demoapp.bookshelf.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Service
@Slf4j
@Transactional
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
