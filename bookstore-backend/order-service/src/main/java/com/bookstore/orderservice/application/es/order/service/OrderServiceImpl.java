package com.bookstore.orderservice.application.es.order.service;

import com.bookstore.orderservice.application.client.service.IWebClient;
import com.bookstore.orderservice.application.es.cart_item.query.model.CartItemQueryRepository;
import com.bookstore.orderservice.application.es.cart_item.query.model.entity.CartItemQueryEntity;
import com.bookstore.orderservice.application.es.order.query.model.OrderQueryRepository;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantity;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private CartItemQueryRepository repository;

    @Autowired
    private IWebClient webClient;

    @Override
    public List<CheckProductQuantityResponse> checkProductQuantity(String cartId, String bearToken) {
        List<CartItemQueryEntity> cartItems = repository.getAllByCartId(cartId);
        List<CheckProductQuantity> request = new ArrayList<>();
        cartItems.forEach(cartItem -> {
            request.add(CheckProductQuantity
                    .builder()
                    .productId(cartItem.getProductId())
                    .quantity(cartItem.getQuantity())
                    .build());
        });
        System.out.println("cartItems : " + cartItems);
        System.out.println("request : " + request);
        return webClient.checkProductQuantity(request, bearToken);
    }
}
