package com.demoapp.bookshelf.controller;

import com.demoapp.bookshelf.service.BookService;
import com.demoapp.bookshelf.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShelfController {

    private final ShelfService shelfService;
    private final BookService bookService;

    @Autowired
    public ShelfController(ShelfService shelfService, BookService bookService) {
        this.shelfService = shelfService;
        this.bookService = bookService;
    }

    @GetMapping("shelves")
    public String getListOfShelves(Model model) {
        model.addAttribute("shelves", shelfService.getBookShelves());
        return "shelves";
    }

    @GetMapping("books")
    public String getListOfBooks(Model model) {
        model.addAttribute("books", bookService.getListOfBooks());
        return "books";
    }
}
