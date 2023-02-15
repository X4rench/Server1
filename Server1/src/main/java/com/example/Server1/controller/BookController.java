package com.example.Server1.controller;

import com.example.Server1.entity.BookEntity;
import com.example.Server1.repo.BookRepo;
import com.example.Server1.response.BaseResponse;
import com.example.Server1.response.BookListResponse;
import com.example.Server1.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
private BookService service;
public BookController(BookService service){this.service=service;}
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll(){
    return ResponseEntity.ok(new BookListResponse(service.getAll()));

    }
   @PostMapping("/add")
    public ResponseEntity<BaseResponse> registration(@RequestBody BookEntity data){
    try{service.save(data);
    return ResponseEntity.ok(new BaseResponse(true, "Книга добавлена"));
    }
    catch (Exception e) {
        return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
    }
    }
 @PostMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> unregistration(@PathVariable Long id){
        try{service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }}

@PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data){
    try {
        service.save(data);
        return ResponseEntity.ok(new BaseResponse(true,"Внесения изменены"));

    } catch (Exception e){
        return ResponseEntity.badRequest().body(new BaseResponse(false,e.getMessage()));
    }
}

}





