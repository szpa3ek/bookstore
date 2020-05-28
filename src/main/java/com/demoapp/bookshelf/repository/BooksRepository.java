package com.demoapp.bookshelf.repository;

import com.demoapp.bookshelf.persistence.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository {

    Book getBookById(Long id);

    Book getBookByTitle(String title);

    Book getBookByIsbn(String isbn);

    Book saveBook(Book b);

    void deleteBook(Book b);
}
