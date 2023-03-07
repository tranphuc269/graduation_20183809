package com.bookstore.orderservice.application.es.order.query.model;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import com.bookstore.orderservice.application.es.order.query.model.entity.OrderQueryEntity;

import java.util.List;

public interface OrderQueryRepository
        extends JpaRepository<OrderQueryEntity, String> {
    @NotNull
    List<OrderQueryEntity> findAllByUserId(String userId);

    OrderQueryEntity findByOrderCheckingId(String orderCheckingId);
}
