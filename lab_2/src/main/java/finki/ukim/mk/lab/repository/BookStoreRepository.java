package finki.ukim.mk.lab.repository;

import finki.ukim.mk.lab.model.BookStore;
import finki.ukim.mk.lab.model.bootstrap.DataHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookStoreRepository {
    public List<BookStore> findAll(){
        return DataHolder.bookStores;
    }
    public Optional<BookStore> findById(Long id){
        return DataHolder.bookStores.stream()
                .filter(bs->bs.getId().equals(id)).findFirst();
    }
}
