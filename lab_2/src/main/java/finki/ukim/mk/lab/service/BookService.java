package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.model.exceptions.BookNotFound;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listBooks();
    Author addAuthorToBook(Long authorId, String isbn);
    Book findBookByIsbn(String isbn);
    Optional<Book> findBookById(Long id);

    void removeBookById(Long id);
    void save(String title, String isbn, String genre, int year, Long bookstoreId) throws BookNotFound;
}
