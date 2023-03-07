package com.bookstore.orderservice.application.es.cart_item.query.api.projection;

import com.bookstore.orderservice.application.es.cart_item.query.model.CartItemQueryRepository;
import com.bookstore.orderservice.application.es.cart_item.query.model.dto.CartItemResponse;
import com.bookstore.orderservice.application.es.cart_item.query.model.entity.CartItemQueryEntity;
import com.bookstore.orderservice.application.es.cart_item.query.api.queries.GetListCartItemQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CartItemProjection {

    @Autowired
    private CartItemQueryRepository repository;


    @QueryHandler
    public List<CartItemResponse> handle(GetListCartItemQuery query) {
        System.out.println("Query handler");
        List<CartItemQueryEntity> entities = repository.getAllByCartId(query.getCartId());
        System.out.println("entities : " + entities);
        List<CartItemResponse> responses = entities
                .stream()
                .map(entity -> CartItemResponse
                        .builder()
                        .cartItemId(entity.getCartItemId())
                        .productId(entity.getProductId())
                        .images(entity.getListImages())
                        .productName(entity.getProductName())
                        .productPrice(entity.getProductPrice())
                        .productShortContent(entity.getProductShortContent())
                        .quantity(entity.getQuantity())
                        .build())
                .collect(Collectors.toList());
        System.out.println("responses : " + responses);
        return responses;
    }
}
