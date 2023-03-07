package com.bookstore.orderservice.application.es.cart.query.model;

import com.bookstore.orderservice.application.es.cart.query.model.entity.CartQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartQueryRepository extends JpaRepository<CartQueryEntity, String> {
    Optional<CartQueryEntity> findByUserId(String userId);
}
