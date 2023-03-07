package com.bookstore.catalogservice.application.es.product.query.api.queries;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetRandomProductByPageable {
    private int offset;
    private int limit;
}
