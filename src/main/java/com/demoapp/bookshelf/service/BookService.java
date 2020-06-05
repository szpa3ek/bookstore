package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.persistence.model.Book;
import com.demoapp.bookshelf.persistence.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


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
        book.setPerson(person);
        entityManager.persist(book);
        return book;
    }

    public Book find(long id) {
        return entityManager.find(Book.class, id);
    }

    public List findAll() {
        Query query = entityManager.createNamedQuery("query_find_all_books", Book.class);
        return query.getResultList();
    }
}
