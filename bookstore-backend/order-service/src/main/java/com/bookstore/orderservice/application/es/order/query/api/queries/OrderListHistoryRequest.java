package com.bookstore.orderservice.application.es.order.query.api.queries;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
@Getter
@Setter
public class OrderListHistoryRequest {

    private String userId;

}
