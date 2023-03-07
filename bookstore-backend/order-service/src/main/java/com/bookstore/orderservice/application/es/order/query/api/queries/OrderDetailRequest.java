package com.bookstore.orderservice.application.es.order.query.api.queries;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
@Getter
public class OrderDetailRequest {
    private String orderId;
}
