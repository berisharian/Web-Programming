package finki.ukim.mk.lab.model.bootstrap;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.Book;
import finki.ukim.mk.lab.model.BookStore;
import lombok.Getter;
import lombok.Lombok;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
@Getter
@Component
public class DataHolder {
    public static List<Author> authors=new ArrayList<>(5);
    public static List<Book> books=new ArrayList<>(5);
    public static List<BookStore> bookStores=new ArrayList<>();
    @PostConstruct
    public void init(){
        BookStore bs1= new BookStore("Literatura1", "Skopje", "Lib address");
        BookStore bs2= new BookStore("Literatura2", "Tetovo", "Lib address");
        BookStore bs3= new BookStore("Literatura3", "Struga", "Lib address");
        BookStore bs4= new BookStore("Literatura4", "Ohrid", "Lib address");
        BookStore bs5= new BookStore("Literatura5", "Veles", "Lib address");
        bookStores.add(bs1);
        bookStores.add(bs2);
        bookStores.add(bs3);
        bookStores.add(bs4);
        bookStores.add(bs5);


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

        List<Author> book1Authors = new ArrayList<>();
        book1Authors.add(a1);
        Book book1 = new Book("ISBN123456", "The Mystery of the Hidden Clues", "Mystery", 2020);
        book1.setBookStore(bookStores.get(0));

        List<Author> book2Authors = new ArrayList<>();
        book2Authors.add(a2);
        book2Authors.add(a3);
        Book book2 = new Book("ISBN789012", "Poems of Serenity", "Poetry", 2019);
        book2.setBookStore(bookStores.get(1));

        List<Author> book3Authors = new ArrayList<>();
        book3Authors.add(a3);
        Book book3 = new Book("ISBN345678", "Explorers of the Cosmos", "Science Fiction", 2022);
        book3.setBookStore(bookStores.get(3));

        List<Author> book4Authors = new ArrayList<>();
        book4Authors.add(a4);
        book4Authors.add(a5);
        Book book4 = new Book("ISBN901234", "The Adventures of Teddy Bear", "Children's", 2018);
        book4.setBookStore(bookStores.get(2));

        List<Author> book5Authors = new ArrayList<>();
        book5Authors.add(a5);
        Book book5 = new Book("ISBN567890", "Ancient Civilizations: Unearthed Mysteries", "History", 2021);
        book5.setBookStore(bookStores.get(4));

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);


//        Author a1=new Author(0, "Harper", "Lee", "Lee's writing focused on racial injustice and moral growth in the American South.");
//        Author a2=new Author(1, "F. Scott", "Fitzgerald", "A leading figure of the Roaring Twenties, Fitzgerald's writing captured the Jazz Age's decadence and disillusionment. ");
//        Author a3=new Author(2, "Suzanne", "Collins", "Collins has contributed significantly to the world of literature, combining social commentary with engaging storytelling.");
//        Author a4=new Author(3, "Dan", "Brown", "American author best known for his thrillers.");
//        Author a5=new Author(4, "J.R.R", "Tolkien", "English writer, philologist, and professor.");
//        authors.add(a1);
//        authors.add(a2);
//        authors.add(a3);
//        authors.add(a4);
//        authors.add(a5);
//        Book book1=new Book("111111", "To Kill a Mockingbird", "Classic Fiction", 1960);
//        book1.setBookStore(bookStores.get(0));
//        Book book2=new Book("222222", "The Great Gatsby", "Literary Fiction", 1925);
//        book2.setBookStore(bookStores.get(1));
//        Book book3=new Book("333333", "The Hunger Games", "Science Fiction", 2008);
//        book3.setBookStore(bookStores.get(2));
//        Book book4=new Book("444444", "The Da Vinci Code", "Mystery, Thriller", 2003);
//        book4.setBookStore(bookStores.get(3));
//        Book book5=new Book("555555", "The Lord of the Rings", "Fantasy", 1954);
//        book5.setBookStore(bookStores.get(4));
//        books.add(book1);
//        books.add(book2);
//        books.add(book3);
//        books.add(book4);
//        books.add(book5);
//
//
//        BookStore bs1= new BookStore("Literatura1", "Skopje", "Lib address");
//        BookStore bs2= new BookStore("Literatura2", "Tetovo", "Lib address");
//        BookStore bs3= new BookStore("Literatura3", "Struga", "Lib address");
//        BookStore bs4= new BookStore("Literatura4", "Ohrid", "Lib address");
//        BookStore bs5= new BookStore("Literatura5", "Veles", "Lib address");
//        bookStores.add(bs1);
//        bookStores.add(bs2);
//        bookStores.add(bs3);
//        bookStores.add(bs4);
//        bookStores.add(bs5);
//
//
  }
}
