package com.bookstore.catalogservice.application.es.product.query.api.queries;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class AddProductToCartQuery {
    private String productId;
    private String userId;
}
