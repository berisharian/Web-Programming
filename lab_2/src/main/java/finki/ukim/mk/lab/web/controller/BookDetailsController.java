package finki.ukim.mk.lab.web.controller;

import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.service.AuthorService;
import finki.ukim.mk.lab.service.BookService;
import finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book-details")
public class BookDetailsController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;

    public BookDetailsController(BookService bookService,
                                 BookStoreService bookStoreService,
                                 AuthorService authorService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
    }
    @GetMapping("/book/{id}")
    public String getBookDetailsPage(@PathVariable Long id, Model model){
        Book bookById=bookService.findBookById(id).get();
        model.addAttribute("selecetedBook", bookById);
        return "bookDetails";
    }
}
