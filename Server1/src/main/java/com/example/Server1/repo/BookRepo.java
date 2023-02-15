package com.example.Server1.repo;

import com.example.Server1.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {

}
