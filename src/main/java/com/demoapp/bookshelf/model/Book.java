package com.demoapp.bookshelf.model;

import lombok.Data;

@Data
public class Book {

    private Person authors;
    private String title;
    private String isbn;
}
