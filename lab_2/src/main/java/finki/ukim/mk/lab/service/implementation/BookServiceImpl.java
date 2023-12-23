package finki.ukim.mk.lab.service.implementation;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.model.BookStore;
import finki.ukim.mk.lab.model.exceptions.BookNotFound;
import finki.ukim.mk.lab.repository.BookRepository;
import finki.ukim.mk.lab.repository.BookStoreRepository;
import finki.ukim.mk.lab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookStoreRepository bookStoreRepository;

    public BookServiceImpl(BookRepository bookRepository, BookStoreRepository bookStoreRepository) {
        this.bookRepository = bookRepository;
        this.bookStoreRepository = bookStoreRepository;
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
    public Optional<Book> findBookById(Long id){
        return bookRepository.findAll().stream()
                .filter(b->b.getId().equals(id)).findFirst();
    }
    public void removeBookById(Long id){
        bookRepository.findAll().removeIf(b->b.getId().equals(id));
    }

    @Override
    public void save(String title, String isbn, String genre, int year, Long bookstoreId) throws BookNotFound {
        BookStore bookStore=bookStoreRepository.findById(bookstoreId)
                .orElseThrow(()->new BookNotFound(bookstoreId));
        bookRepository.addBook(title, isbn, genre, year, bookStore);
    }

}
