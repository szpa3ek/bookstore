package com.demoapp.booksfelf.reactive.service;

import com.demoapp.booksfelf.reactive.model.Book;
import com.demoapp.booksfelf.reactive.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@Transactional
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Mono<Book> insert(Book book) {
        Book bookToAdd = new Book();
        bookToAdd.setTitle(book.getTitle());
        bookToAdd.setIsbn(book.getIsbn());
        return bookRepository.save(bookToAdd)
                .map(b ->
                {
                    Book book1 = new Book();
                    book1.setTitle(b.getTitle());
                    book1.setIsbn(b.getIsbn());
                    return book1;
                });
    }

    public Flux<Book> findAll() {
        return bookRepository.findAll().map(b ->
        {
            Book book1 = new Book();
            book1.setTitle(b.getTitle());
            book1.setIsbn(b.getIsbn());
            return book1;
        });
    }
}
