package finki.ukim.mk.lab.web.controller;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.service.AuthorService;
import finki.ukim.mk.lab.service.BookService;
import finki.ukim.mk.lab.service.BookStoreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/author")
public class AuthorController {
    private final BookService bookService;
    private final BookStoreService bookStoreService;
    private final AuthorService authorService;

    public AuthorController(BookService bookService, BookStoreService bookStoreService, AuthorService authorService) {
        this.bookService = bookService;
        this.bookStoreService = bookStoreService;
        this.authorService = authorService;
    }

    @GetMapping("/add-author/{id}")
    public String addAuthorPage(@RequestParam(required = false)String error,
                                @PathVariable Long id,
                                Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Author> authors = authorService.listAuthors();
        model.addAttribute("authors", authors);
        model.addAttribute("sb", id);
        return "authorList";
    }

    @PostMapping("/add")
    public String addAuthor(Long bookId,
                            @RequestParam Long existingAuthor) {
        Book book = bookService.findBookById(bookId).get();

        Author selectedAuthor = authorService.findById(existingAuthor);

        Optional<Author> first = book.getAuthors().stream()
                .filter(i -> {
                    Long authorId = i.getId(); // Assuming i.getId() returns Long
                    return authorId.equals(existingAuthor);
                })
                .findFirst();

        if(first.isPresent()){
            return "redirect:/author/add-author/" + bookId + "?error=AuthorExistsAlready";
        }else{
            book.getAuthors().add(selectedAuthor);
            return "redirect:/books";
        }
    }

    @GetMapping("/remove-author/{id}")
    public String removeAuthors(@PathVariable Long id){
        Book book = bookService.findBookById(id).get();
        book.getAuthors().clear();
        return "redirect:/books";
    }

}
