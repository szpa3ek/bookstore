package com.demoapp.bookshelf.service;

import com.demoapp.bookshelf.model.Book;
import com.demoapp.bookshelf.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
@Transactional
public class BookService {

    @PersistenceContext
    private EntityManager em;

     public Book createBook(Long id, String title, String isbn, Person author) {
        Book book = new Book();
        book.setId(id);
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setAuthors(author);
        em.persist(book);
        return book;
    }

    public Book createBook(Book book) {
        em.persist(book);
        return book;
    }
    public List<Book> listAll() {
         Person person = new Person();
         person.setFirstName("Frank");
         person.setLastName("Herbert");
         Book book = new Book();
         book.setTitle("Diuna");
         book.setIsbn("978-3-598-21500-1");
         book.setAuthors(person);
        // em.persist(shelves);
        return Arrays.asList(book);
    }

    public void removeBook(Long id) {
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.remove(book);
        }
    }

    public void removeBook(Book book) {
        em.remove(em.merge(book));
    }
}
