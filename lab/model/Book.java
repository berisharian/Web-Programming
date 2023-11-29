package finki.ukim.mk.lab.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Book {
    private String isbn;
    private String title;
    private String genre;
    private int year;
    private List<Author> authors;

    public Book(String isbn, String title, String genre, int year) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.authors = new ArrayList<>();
    }

    //    public void addAuthorToBook(Author author){
//        this.authors.add(author);
//    }
}
