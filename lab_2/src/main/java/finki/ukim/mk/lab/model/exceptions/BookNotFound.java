package finki.ukim.mk.lab.model.exceptions;

public class BookNotFound extends Exception{
    public BookNotFound(Long id) {
        super(String.format("Book with id: %d not found", id));
    }
}
