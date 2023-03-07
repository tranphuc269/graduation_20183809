package com.bookstore.orderservice.application.es.order.command.write_model.dto;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateOrderRequest {
    private String paymentMethod;

    private String cartId;

    private CreateOrderShippingAddressRequest address;
}
