package com.bookstore.orderservice.application.es.cart.command.model.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateCartRequest {
    private String userId;
}
