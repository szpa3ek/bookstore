package com.demoapp.bookshelf.persistence.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Book> book;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<CD> cd;

    public Person() {
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<CD> getCd() {
        return cd;
    }

    public void setCd(List<CD> cd) {
        this.cd = cd;
    }
}
