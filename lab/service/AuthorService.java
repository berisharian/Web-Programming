package finki.ukim.mk.lab.service;

import finki.ukim.mk.lab.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> listAuthors();
    Optional<Author> findById(Long id);
}
