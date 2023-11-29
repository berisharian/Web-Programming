package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.Author;
import finki.ukim.mk.lab.model.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository {
    List<Author> authors=new ArrayList<>(5);

    public List<Author> findAll(){
        return DataHolder.authors;
    }
    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream().filter(r->r.getId()==id).findFirst();
    }

}
