package com.example.demo.response;

import com.example.demo.entity.PublisherEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublisherListResponse extends BaseResponse{

    public PublisherListResponse(boolean success, String message) {
        super(true, "Издательства");
        this.data = data;
    }

    private Iterable<PublisherEntity> data;
}
