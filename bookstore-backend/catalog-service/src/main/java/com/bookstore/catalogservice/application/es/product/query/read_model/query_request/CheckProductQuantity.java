package com.bookstore.catalogservice.application.es.product.query.read_model.query_request;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CheckProductQuantity {
    String productId;
    int quantity;
}
