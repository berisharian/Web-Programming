package finki.ukim.mk.lab.service.implementation;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.repository.AuthorRepository;
import finki.ukim.mk.lab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> findById(Long id) {
       return authorRepository.findById(id);
    }

}