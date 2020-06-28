package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Book;
import com.demoapp.bookshelf.persistence.model.Person;
import lombok.extern.slf4j.Slf4j;
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
    @PersistenceContext
    private EntityManager entityManager;

    public Book insert(String title, String isbn, Person person) {
        Book book = new Book();
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setAuthors(List.of(person));
        entityManager.persist(book);
        return book;
    }

    public Book find(long id) {
        return entityManager.find(Book.class, id);
    }

    public Optional<Book> findByTitle(String title) {
        Book book = entityManager.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class)
                .setParameter("title", title)
                .getSingleResult();
        return book != null ? Optional.of(book) : Optional.empty();
    }

    public List<Book> findAll() {
        TypedQuery<Book> query_find_all_books = entityManager.createNamedQuery("query_find_all_books", Book.class);
        return query_find_all_books.getResultList();
    }
}
