package com.example.demo.servise;

import com.example.demo.entity.BookEntity;
import com.example.demo.repo.BookRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public BookEntity save(BookEntity book){
        //ValidationException.Validate(book);
        return repo.save(book);
    }


    public void delete(Long id) {
        repo.deleteById(id);
    }

   /* public void delete(String title) {
        repo.deleteByTitle(title);
    }*/

    public Iterable<BookEntity> getAll() {
        return repo.findAll();
    }
/*    public BookEntity getId(Long id) { return repo.findById(id);

    }*/
    //public BookEntity getId(long id){ return repo.findById(id);}
    public  Iterable<BookEntity> getPublisher(String title){
        return repo.findByTitle(title);
    }
}
