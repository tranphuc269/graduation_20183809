package com.bookstore.orderservice.application.es.cart_item.command.api.events.handler;

import com.bookstore.orderservice.common.domain.exception.BusinessError;
import com.bookstore.orderservice.common.domain.exception.ExceptionCommon;
import com.bookstore.orderservice.application.es.cart_item.command.api.events.AddCartItemEvent;
import com.bookstore.orderservice.application.es.cart_item.command.api.events.RemoveAllCartItemEvent;
import com.bookstore.orderservice.application.es.cart_item.command.api.events.RemoveCartItemEvent;
import com.bookstore.orderservice.application.es.cart_item.command.model.CartItemCommandRepository;
import com.bookstore.orderservice.application.es.cart_item.command.model.entity.CartItemCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CartItemHandler implements ICartItemHandler {

    @Autowired
    public CartItemHandler(CartItemCommandRepository repository) {
        this.repository = repository;
    }

    private CartItemCommandRepository repository;


    @Override
    @EventHandler
    public void on(AddCartItemEvent event) {
        System.out.println("PONG");
        List<CartItemCommandEntity> carts = repository.findAllByCartId(event.getCartId());
        if (carts
                .stream()
                .map(CartItemCommandEntity::getProductId)
                .collect(Collectors
                        .toList())
                .contains(event.getProductId())) {
            CartItemCommandEntity entity =
                    repository.findByProductId(event.getProductId()).get();
            entity.setQuantity(entity.getQuantity() + 1);
            repository.save(entity);
        } else {
            System.out.println("b");
            CartItemCommandEntity entity = CartItemCommandEntity
                    .builder()
                    .cartId(event.getCartId())
                    .productId(event.getProductId())
                    .quantity(event.getQuantity())
                    .productName(event.getProductName())
                    .images(event.getImages())
                    .productPrice(event.getProductPrice())
                    .productShortContent(event.getProductShortDescription())
                    .build();
            entity.setStatus(1);
            entity.setCreateTime(new Date());
            entity.setUpdateTime(new Date());
            repository.save(entity);
        }
    }

    @Override
    @EventHandler
    public void on(RemoveCartItemEvent event) {
        Optional<CartItemCommandEntity> entityOptional =
                repository.findById(event.getCartItemId());
        if (entityOptional.isEmpty()) {
            throw new ExceptionCommon(new BusinessError(404,
                    "Not found cart item",
                    HttpStatus.NOT_FOUND));
        } else {
            repository.delete(entityOptional.get());
        }
    }


    @Override
    @EventHandler
    public void on(RemoveAllCartItemEvent event) {
        repository.deleteAllByCartId(event.getCartId());
    }
}
