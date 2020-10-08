package com.demoapp.bookshelf.controller;

import com.demoapp.bookshelf.persistence.model.Person;
import com.demoapp.bookshelf.persistence.model.Shelf;
import com.demoapp.bookshelf.service.BookService;
import com.demoapp.bookshelf.service.CDService;
import com.demoapp.bookshelf.service.PersonService;
import com.demoapp.bookshelf.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ShelfController {

    private final ShelfService shelfService;
    private final BookService bookService;
    private final PersonService personService;
    private final CDService cdService;

    public ShelfController(ShelfService shelfService, BookService bookService, PersonService personService, CDService cdService) {
        this.shelfService = shelfService;
        this.bookService = bookService;
        this.personService = personService;
        this.cdService = cdService;
    }

    @GetMapping("shelves")
    public String getListOfShelves(Model model) {
        model.addAttribute("shelves", shelfService.findAll());
        return "shelves";
    }

    @PostMapping(value = "/saveShelf")
    public String saveShelf(@ModelAttribute("shelf") Shelf shelf, ModelMap model) {
        model.addAttribute("name", shelf.getName());
        return "shelf";
    }

    @GetMapping(value = "/books")
    String showAllBooks(Model model) {
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

    @PostMapping(value = "/cd")
    String newCD(String title, ArrayList<String> tracks, String firstName, String lastName) {
        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        cdService.insert(title, tracks, person);
        return "redirect:/cd";
    }

    @GetMapping(value = "/cd")
    String showAllCDs(Model model) {
        model.addAttribute("cd", cdService.findAll());
        model.addAttribute("person", new Person());
        return "cd";
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
