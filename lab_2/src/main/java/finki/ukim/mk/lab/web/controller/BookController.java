package finki.ukim.mk.lab.web.controller;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.model.BookStore;
import finki.ukim.mk.lab.model.exceptions.BookNotFound;
import finki.ukim.mk.lab.service.AuthorService;
import finki.ukim.mk.lab.service.BookService;
import finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Retention;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;

    public BookController(BookService bookService, BookStoreService bookStoreService, AuthorService authorService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
    }

    @GetMapping()
    public String getBooksPage(@RequestParam(required = false) String error, Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }

        List<Book> books=bookService.listBooks();
        model.addAttribute("books", books);
        return "listBooks";
    }
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id){
        this.bookService.removeBookById(id);
        return "redirect:/books";
    }
    @GetMapping("/edit/{id}")
    public String getEditBookForm(@PathVariable Long id, Model model){
        if(this.bookService.findBookById(id).isPresent()){
            List<Author> authors=authorService.listAuthors();
            Book bookById=bookService.findBookById(id).get();
            List<BookStore> bookStores=bookStoreService.findAll();
            model.addAttribute("bookStores", bookStores);
            model.addAttribute("book", bookById);
            model.addAttribute("authors", authors);
            return "add-book";
        }
        return "redirect:/books?error=BookNotFound";
    }
    @GetMapping("/add-form")
    public String addBookPage(Model model){
        List<BookStore> bookStores=bookStoreService.findAll();
        List<Author> authors=authorService.listAuthors();
        model.addAttribute("bookStores", bookStores);
        model.addAttribute("authors", authors);
        return "add-book";
    }

    @PostMapping("/add")
    public String saveBook(@RequestParam String title,
                           @RequestParam String isbn,
                           @RequestParam String genre,
                           @RequestParam int year,
                           @RequestParam Long bookstoreId){
        try {
            this.bookService.save(title, isbn, genre, year, bookstoreId);
        } catch (BookNotFound e) {
            throw new RuntimeException(e);
        }
        return "redirect:/books";
    }

}
