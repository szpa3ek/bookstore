package com.demoapp.bookshelf.controller;

import com.demoapp.bookshelf.model.Book;
import com.demoapp.bookshelf.repository.BooksRepository;
import com.demoapp.bookshelf.service.BookService;
import com.demoapp.bookshelf.service.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShelfController {

    private final ShelfService shelfService;
    private final BookService bookService;

    /*@Autowired
    BooksRepository booksRepository;*/

    @Autowired
    public ShelfController(ShelfService shelfService, BookService bookService) {
        this.shelfService = shelfService;
        this.bookService = bookService;
    }

    @GetMapping("shelves")
    public String getListOfShelves(Model model) {
        model.addAttribute("shelves", shelfService.listAll());
        return "shelves";
    }

    /*@GetMapping("books")
    public String getListOfBooks(Model model) {
        model.addAttribute("books", bookService.listAll());
        model.addAttribute("booksSubmitted", new Book());
        return "books";
    }*/

    @GetMapping(value = "books")
    public ModelAndView showBooks() {
        return new ModelAndView("books", "book", new Book());
    }

    @PostMapping (value = "books")
    public String submitBook(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        model.addAttribute("title", book.getTitle());
        model.addAttribute("isbn", book.getIsbn());
        model.addAttribute("authors", book.getAuthors());
        return "books";
    }

  /*  @PostMapping("books")
    public String bookSubmit(@ModelAttribute("booksSubmitted") Book book) {
        return "books";
    }*/

    @GetMapping("authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", bookService.listAll().get(0).getAuthors());
        return "authors";
    }


  /*  @PostMapping("/books")
    public Book createNote(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PostMapping(value="book/create")
    public String createBook(Book book, Model model) {
        model.addAttribute("book", bookService.createBook(book));
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book());
        model.addAttribute("books", books);
        return "newBookForm";
    }*/

/*    @GetMapping(value="/booklist")
    public @ResponseBody
    List<Book> bookListRest() {
        return (List<Book>) .findAll();
    }*/

/*    @PutMapping("books")
    public String createBook(Model model){
        model.addAttribute("book",new Book());
        return "book";
    }*/
    /*public String save(Book book) {
        repository.save(book);
        return "redirect:books";
    }*/

 /*   @GetMapping("books")
    public String getListOfBooks(Model model) {
        model.addAttribute("books", bookService.createBook());
        return "books";
    }*/
}
