package com.bookstore.orderservice.application.es.order_item.query.model;

import com.bookstore.orderservice.application.es.order_item.query.model.entity.OrderItemQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface OrderItemQueryRepository extends JpaRepository<OrderItemQueryEntity,
        String> {
    List<OrderItemQueryEntity> findAllByOrderId(String orderId);

    @Query(value = "SELECT sum(quantity * productPrice) FROM OrderItemQueryEntity where orderId = :orderId")
    BigDecimal totalPrice(String orderId);

    int countByOrderId(String orderId);
}
