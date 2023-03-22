package com.example.demo.utils;

import com.example.demo.entity.BookEntity;
import com.example.demo.exception.ValidationExceptionBook;

import javax.xml.bind.ValidationException;

public class BookValidationUtils {
    public static void bookValidationUtils(BookEntity book) throws ValidationExceptionBook {
        String title = book.getTitle();
        if (title == null || title.isBlank()) {
            throw new ValidationExceptionBook("Поле названия не может быть пустым");
        }
        if (book.getAuthor() == null) {
            throw new ValidationExceptionBook("Нужно выбрать автора");
        }
        if (book.getPublisher() == null) {
            throw new ValidationExceptionBook("Нужно выбрать издательство");
        }
    }
}
