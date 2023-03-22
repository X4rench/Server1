package com.example.demo.response;

import com.example.demo.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorResponse extends BaseResponse{
    public AuthorResponse(boolean success, String message, AuthorEntity author) {
        super(success,message);
        this.author = author;
    }
    public AuthorResponse(AuthorEntity author) {
        super(true, "Author data!");
    }
    private AuthorEntity author;
}
