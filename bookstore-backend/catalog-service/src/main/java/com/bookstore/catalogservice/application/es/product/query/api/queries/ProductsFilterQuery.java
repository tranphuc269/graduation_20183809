package com.bookstore.catalogservice.application.es.product.query.api.queries;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Builder
public class ProductsFilterQuery {
    private String authorId;
    private String categoryId;

    String sort; // ratting_count,asc -- create_date,asc

    private int offset;
    private int limit;
}
