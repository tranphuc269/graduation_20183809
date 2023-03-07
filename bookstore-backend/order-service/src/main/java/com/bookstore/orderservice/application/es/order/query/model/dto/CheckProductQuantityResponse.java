package com.bookstore.orderservice.application.es.order.query.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CheckProductQuantityResponse {
    String productId;
    boolean isEnough;
}