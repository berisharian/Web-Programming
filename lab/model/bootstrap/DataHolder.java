package finki.ukim.mk.lab.model.bootstrap;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Getter
@Component
public class DataHolder {
    public static List<Author> authors=new ArrayList<>(5);
    public static List<Book> books=new ArrayList<>(5);
    @PostConstruct
    public void init(){
        Author a1=new Author(0, "Harper", "Lee", "Lee's writing focused on racial injustice and moral growth in the American South.");
        Author a2=new Author(1, "F. Scott", "Fitzgerald", "A leading figure of the Roaring Twenties, Fitzgerald's writing captured the Jazz Age's decadence and disillusionment. ");
        Author a3=new Author(2, "Suzanne", "Collins", "Collins has contributed significantly to the world of literature, combining social commentary with engaging storytelling.");
        Author a4=new Author(3, "Dan", "Brown", "American author best known for his thrillers.");
        Author a5=new Author(4, "J.R.R", "Tolkien", "English writer, philologist, and professor.");
        authors.add(a1);
        authors.add(a2);
        authors.add(a3);
        authors.add(a4);
        authors.add(a5);
        books.add(new Book("111111", "To Kill a Mockingbird", "Classic Fiction", 1960));
        books.add(new Book("222222", "The Great Gatsby", "Literary Fiction", 1925));
        books.add(new Book("333333", "The Hunger Games", "Science Fiction", 2008));
        books.add(new Book("444444", "The Da Vinci Code", "Mystery, Thriller", 2003));
        books.add(new Book("555555", "The Lord of the Rings", "Fantasy", 1954));

    }
}
