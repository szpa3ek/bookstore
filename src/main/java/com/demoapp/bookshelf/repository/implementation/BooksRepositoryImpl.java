package com.demoapp.bookshelf.repository.implementation;

import com.demoapp.bookshelf.persistence.model.Book;
import com.demoapp.bookshelf.repository.BooksRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BooksRepositoryImpl implements BooksRepository {

    private EntityManager em;

    public BooksRepositoryImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Book getBookById(Long id) {
        return em.find(Book.class, id);
    }

    @Override
    public Book getBookByTitle(String title) {
        TypedQuery<Book> bookTypedQuery = em.createQuery("SELECT b FROM Book b WHERE b.title = :title", Book.class);
        bookTypedQuery.setParameter("title", title);
        return bookTypedQuery.getSingleResult();
    }

    @Override
    public Book getBookByIsbn(String isbn) {
        TypedQuery<Book> bookTypedQuery = em.createQuery("SELECT b FROM Book b WHERE b.isbn = :isbn", Book.class);
        bookTypedQuery.setParameter("isbn", isbn);
        return bookTypedQuery.getSingleResult();
    }

    @Override
    public Book saveBook(Book book) {
        if (book.getId() == null) {
            em.persist(book);
        } else {
            book = em.merge(book);
        }
        return book;
    }

    @Override
    public void deleteBook(Book b) {
        if (em.contains(b)) {
            em.remove(b);
        } else {
            em.merge(b);
        }
    }
}
