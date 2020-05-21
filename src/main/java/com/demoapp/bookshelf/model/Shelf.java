package com.demoapp.bookshelf.model;

import lombok.Data;
import java.util.List;

@Data
public class Shelf {

    private List<Book> books;
    private String name;
}
