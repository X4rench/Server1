package com.example.demo.controller;

import com.example.demo.entity.BookEntity;
import com.example.demo.exception.ValidationExceptionBook;
import com.example.demo.response.BaseResponse;
import com.example.demo.response.BookListResponse;
import com.example.demo.response.BookResponse;
import com.example.demo.servise.BookService;
import com.example.demo.utils.BookValidationUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("api/v1/book")
public class BookController {

    private BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }


    @PostMapping("/add")
    public ResponseEntity <BookResponse> add(@RequestBody BookEntity data) {
        try {
            BookValidationUtils.bookValidationUtils(data);
            service.save(data).getId();
            return ResponseEntity.ok(new BookResponse(true, "Книга добавлена.",data));

        } catch (ValidationExceptionBook e) {
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(),null));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(),null));
        }
    }
   /* {

        "title": "Сияние",
            "author": {
        "id": 1,
                "name": "Стивен",
                "lastname": "Евгениевич",
                "surname": "Кинг"
    },
        "publisher": {
        "id": 1,
                "publisher": "АСТ",
                "city": "Белореченск"
    },
        "year": 2004,
            "kind": "Художественное"
    }*/
    @PutMapping("/update")
    public ResponseEntity <BaseResponse> update(@RequestBody BookEntity data) {
        try {
            BookValidationUtils.bookValidationUtils(data);
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения."));
        } catch (ValidationExceptionBook e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга была успешно удалена."));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
    @GetMapping("/search")
    public ResponseEntity<BaseResponse> getPublisher(@RequestParam String title){
        return ResponseEntity.ok(new BookListResponse(service.getPublisher(title)));
    }
    /*http://localhost:2825/api/v1/book/search?title=Сияние*/


}