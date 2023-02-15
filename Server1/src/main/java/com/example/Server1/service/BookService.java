package com.example.Server1.service;

import com.example.Server1.entity.BookEntity;
import com.example.Server1.exception.ValidationException;
import com.example.Server1.repo.BookRepo;
import com.example.Server1.utils.ValidationUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class BookService {

    private final BookRepo repo;
    public BookService (BookRepo repo){
        this.repo= repo;

    }

        public void save(BookEntity book) throws ValidationException {
            ValidationUtils.validationBook(book);
            repo.save(book);
    }
    public void delete(Long id){repo.deleteById(id);}
    public Iterable<BookEntity> getAll(){return repo.findAll();}

}
