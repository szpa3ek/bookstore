package com.demoapp.bookshelf.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@NamedQuery(query = "select b from Book b", name = "query_find_all_books")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;
    @ManyToOne (cascade = {CascadeType.ALL})
    private Person person;
    @ManyToOne(cascade = CascadeType.ALL)
    private Shelf shelf;

    public Book() {
    }

    public Book(String title, String isbn) {
        this.title = title;
        this.isbn = isbn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}