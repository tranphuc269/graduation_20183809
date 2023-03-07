package com.bookstore.catalogservice.application.es.product.command.write_model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnableProductRequest {
    private String productId;
}
