package com.demoapp.bookshelf.model;

import java.util.List;

public class Shelf {

    private Long shelfId;
    private String name;
    private List<Book> books;

    public Shelf() {
    }

    public Shelf(Long shelfId, String name) {
        this.shelfId = shelfId;
        this.name = name;
    }

    public Long getShelfId() {
        return shelfId;
    }

    public void setShelfId(Long shelfId) {
        this.shelfId = shelfId;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
