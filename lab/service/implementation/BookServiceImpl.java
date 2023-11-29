package finki.ukim.mk.lab.service.implementation;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.repository.BookRepository;
import finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Author addAuthorToBook(Long authorId, String isbn) {
       Author a=bookRepository.authorId(authorId);
       Book b=bookRepository.findByIsbn(isbn);
       bookRepository.addAuthorToBook(a, b);
       return a;
    }

    @Override
    public Book findBookByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn);
    }
}
