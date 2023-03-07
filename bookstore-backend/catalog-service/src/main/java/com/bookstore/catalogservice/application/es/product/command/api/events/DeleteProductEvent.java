package com.bookstore.catalogservice.application.es.product.command.api.events;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@Builder
public class DeleteProductEvent {
    private String productId;
}
