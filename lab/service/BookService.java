package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;

import java.util.List;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
}
