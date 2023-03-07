package com.bookstore.orderservice.application.es.order.command.write_model.dto;


import lombok.*;

@Builder
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipOrderRequest {
    private String orderId;
    private String orderCheckingId;
}
