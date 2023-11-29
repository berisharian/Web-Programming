package finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Author {
    private long id;
    private String name;
    private String surname;
    private String biography;

    public Author(long id, String name, String surname, String biography) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.biography = biography;
    }
}
