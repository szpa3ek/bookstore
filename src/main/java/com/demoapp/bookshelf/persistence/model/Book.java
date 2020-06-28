package com.demoapp.bookshelf.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NamedQuery(query = "select b from Book b", name = "query_find_all_books")
public class Book extends Item implements Serializable {

    private String isbn;

    public Book() {
    }

    public Book(String title) {
        super.setTitle(title);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
