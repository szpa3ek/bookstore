package com.demoapp.bookshelf.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQuery(query = "select s from Shelf s", name = "query_find_all_shelves")
public class Shelf {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shelfId;
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelf", fetch = FetchType.LAZY)
    private List<Book> books;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelf", fetch = FetchType.LAZY)
    private List<CD> cds;

    public Shelf() {
    }

    public Shelf(List<Book> books, String name) {
        this.books = books;
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

    public List<CD> getCds() {
        return cds;
    }

    public void setCds(List<CD> cds) {
        this.cds = cds;
    }
}
