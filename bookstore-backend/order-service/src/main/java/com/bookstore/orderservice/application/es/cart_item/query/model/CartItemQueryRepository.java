package com.bookstore.orderservice.application.es.cart_item.query.model;

import com.bookstore.orderservice.application.es.cart_item.query.model.entity.CartItemQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemQueryRepository extends JpaRepository<CartItemQueryEntity, String> {
    List<CartItemQueryEntity> getAllByCartId(String cartId);
}
