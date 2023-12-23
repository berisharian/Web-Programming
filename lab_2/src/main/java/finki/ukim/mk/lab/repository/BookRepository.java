package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.model.BookStore;
import finki.ukim.mk.lab.model.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> findAll(){
        return DataHolder.books;
    }
    public Book findByIsbn(String isbn){
        return DataHolder.books.stream().filter(r->r.getIsbn().equals(isbn)).findFirst().get();
    }
    public Author addAuthorToBook(Author author, Book book){
       DataHolder.books.removeIf(r->r.getAuthors().stream().anyMatch(l->l.getName().equals(author.getName())));
        //   book.addAuthorToBook(author);
       book.getAuthors().add(author);
       return author;
    }
    public Author authorId(Long id){

        return DataHolder.authors.stream().filter(r->r.getId()==id).findFirst().get();
    }
//    public boolean deleteAuthors(Author author, Book book){
//        return DataHolder.books.removeIf(r->r.getAuthors().stream().anyMatch(l->l.getName().equals(author.getName())));
//    }
    public void addBook(String title, String isbn, String genre, int year, BookStore bookStore){
        List<Author> as=new ArrayList<>();
        Optional<Book> first=DataHolder.books.stream().filter(b->b.getIsbn().equals(isbn)).findFirst();
        if(first.isPresent()){
            first.get().setTitle(title);
            first.get().setGenre(genre);
            first.get().setYear(year);
            first.get().setBookStore(bookStore);
            return;
        }
        Book b=new Book(isbn, title, genre, year);
      //  Book b=new Book(isbn, title, genre, year, as);
        b.setBookStore(bookStore);
        DataHolder.books.add(b);
    }


}
