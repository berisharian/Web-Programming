package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.model.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}
