package com.bookstore.orderservice.application.es.order_item.query.api.projection;


import com.bookstore.orderservice.application.es.order_item.query.api.queries.GetOrderItemsByOrderIdQuery;
import com.bookstore.orderservice.application.es.order_item.query.model.OrderItemQueryRepository;
import com.bookstore.orderservice.application.es.order_item.query.model.dto.OrderItemResponse;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderItemProjection {

    @Autowired
    private OrderItemQueryRepository repository;
    @QueryHandler
    public List<OrderItemResponse> handle(GetOrderItemsByOrderIdQuery query) {
        return repository
                .findAllByOrderId(query
                        .getOrderId())
                .stream()
                .map(product -> OrderItemResponse
                        .builder()
                        .orderItemId(product.getOrderItemId())
                        .productId(product.getProductId())
                        .productPrice(product.getProductPrice())
                        .productName(product.getProductName())
                        .productShortContent(product.getProductShortContent())
                        .images(product.getListImages())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }
}
