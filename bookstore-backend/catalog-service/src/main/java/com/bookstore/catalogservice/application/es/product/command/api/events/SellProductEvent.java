package com.bookstore.catalogservice.application.es.product.command.api.events;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Data
public class SellProductEvent {
    private String id;
    private String productId;
    private int quantity;
}
