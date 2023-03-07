package com.bookstore.orderservice.application.es.cart_item.command.model;

import com.bookstore.orderservice.application.es.cart_item.command.model.entity.CartItemCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartItemCommandRepository extends JpaRepository<CartItemCommandEntity, String> {
    void deleteAllByCartId(String cartId);

    List<CartItemCommandEntity> findAllByCartId(String cartId);

    Optional<CartItemCommandEntity> findByProductId(String productId);
}
