package com.bookstore.orderservice.application.es.cart_item.command.model.dto;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RemoveCartItemRequest {
    private String cartItemId;
}
