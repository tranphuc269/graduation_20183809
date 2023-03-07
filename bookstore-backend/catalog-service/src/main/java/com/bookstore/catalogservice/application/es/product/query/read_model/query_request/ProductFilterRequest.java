package com.bookstore.catalogservice.application.es.product.query.read_model.query_request;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ProductFilterRequest {
    private String authorId;
    private String categoryId;

    String sort; // ratting_count,asc -- create_date,asc

    private int offset;
    private int limit;
}
