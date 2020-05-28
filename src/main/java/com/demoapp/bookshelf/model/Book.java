package com.demoapp.bookshelf.model;

import java.util.Objects;

public class Book {

    private Long id;
    private Person authors;
    private String title;
    private String isbn;

    public Book() {
    }

    public Book(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getAuthors() {
        return authors;
    }

    public void setAuthors(Person authors) {
        this.authors = authors;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;

        if (!Objects.equals(id, book.id)) return false;
        if (!Objects.equals(title, book.title)) return false;
        if (!Objects.equals(isbn, book.isbn)) return false;
        return Objects.equals(authors, book.authors);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authors=" + authors +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}
