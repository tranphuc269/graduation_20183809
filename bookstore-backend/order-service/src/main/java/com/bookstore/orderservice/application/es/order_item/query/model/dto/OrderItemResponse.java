package com.bookstore.orderservice.application.es.order_item.query.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class OrderItemResponse {
    private String orderItemId;

    private String productId;
    private double productPrice;

    private String productName;

    private String productShortContent;

    private List<String> images;

    private int quantity;
}
