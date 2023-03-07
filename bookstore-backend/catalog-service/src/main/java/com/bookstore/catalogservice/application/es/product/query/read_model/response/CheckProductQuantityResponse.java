package com.bookstore.catalogservice.application.es.product.query.read_model.response;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CheckProductQuantityResponse {
    String productId;
    boolean isEnough;
}
