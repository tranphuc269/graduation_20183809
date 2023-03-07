package com.bookstore.orderservice.application.es.cart.command.model.dto;


import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveAllCartRequest {
    private String cartId;
}
