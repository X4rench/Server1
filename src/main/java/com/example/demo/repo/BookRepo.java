package com.example.demo.repo;

import com.example.demo.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;


public interface BookRepo extends CrudRepository<BookEntity, Long> {
   // BookEntity findById(long id);
    Iterable<BookEntity> findByTitle(String title);
    Iterable<BookEntity> deleteByTitle(String title);

}
