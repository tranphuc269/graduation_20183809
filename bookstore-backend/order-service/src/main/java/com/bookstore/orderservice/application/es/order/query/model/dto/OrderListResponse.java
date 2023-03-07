package com.bookstore.orderservice.application.es.order.query.model.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;


@Builder
@Data
public class OrderListResponse {
    String orderId;
    String orderCheckingId;
    String orderStatus;
    String paymentMethod;
    String paymentStatus;

    Date createdAt;
    int totalItem;
    BigDecimal totalPrice;
}
