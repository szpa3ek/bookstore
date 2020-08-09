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

    public Book insert(String title, String isbn, Person person) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setAuthors(List.of(person));
        bookRepository.save(book);
        return book;
    }

    public Book find(long id) {
        return bookRepository.findById(id).get();
    }

    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
