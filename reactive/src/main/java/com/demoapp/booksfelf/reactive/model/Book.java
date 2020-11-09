package com.demoapp.booksfelf.reactive.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
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
