package com.bookstore.orderservice.application.es.order.query.api.queries;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class OrderHistoryRequestCheckingQuery {
    private String orderCheckingId;
}
