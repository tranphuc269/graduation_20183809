package com.bookstore.orderservice.application.es.cart.query.api.controller;


import com.bookstore.orderservice.common.application.response.dto.BaseResponse;
import com.bookstore.orderservice.application.es.cart.query.api.queries.GetCartQuery;
import com.bookstore.orderservice.application.es.cart.query.model.dto.CartResponse;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/cart")
public class CartQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("/{cartId}")
    public BaseResponse<CartResponse> getCart(@PathVariable String cartId) {
        GetCartQuery query = GetCartQuery
                .builder()
                .cartId(cartId)
                .build();
        CartResponse response = queryGateway.query(query,
                ResponseTypes
                        .instanceOf(CartResponse.class)).join();
        return BaseResponse.ofSucceeded(response);
    }
}
