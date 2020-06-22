package com.demoapp.bookshelf.controller;

import com.demoapp.bookshelf.persistence.model.Person;
import com.demoapp.bookshelf.persistence.model.Shelf;
import com.demoapp.bookshelf.service.BookService;
import com.demoapp.bookshelf.service.PersonService;
import com.demoapp.bookshelf.service.ShelfService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class ShelfController {

    private final ShelfService shelfService;
    private final BookService bookService;
    private final PersonService personService;

    public ShelfController(ShelfService shelfService, BookService bookService, PersonService personService) {
        this.shelfService = shelfService;
        this.bookService = bookService;
        this.personService = personService;
    }

    @GetMapping("shelves")
    public String getListOfShelves(Model model) {
        model.addAttribute("shelves", shelfService.listAll());
        return "shelves";
    }

    @PostMapping(value = "/saveShelf")
    public String saveShelf(@ModelAttribute("shelf") Shelf shelf, ModelMap model) {
        model.addAttribute("name", shelf.getName());
        return "shelf";
    }

    @GetMapping(value = "/books")
    String showAll(Model model) {
        model.addAttribute("books", bookService.findAll());
        model.addAttribute("person", new Person());
        return "books";
    }

    @PostMapping(value = "/books")
    String newBook(String title, String isbn, String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        bookService.insert(title, isbn, person);
        return "redirect:/books";
    }

    @GetMapping(value = "/authors")
    String showAllAuthors(Model model) {
        model.addAttribute("authors", personService.findAll());
        return "authors";
    }

    @PostMapping(value = "/authors")
    Person newPerson(String firstName, String lastName) {
        return personService.addPerson(firstName, lastName);
    }
}
