package com.bookstore.orderservice.application.es.order_item.command.model;

import com.bookstore.orderservice.application.es.order_item.command.model.entity.OrderItemCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemCommandRepository extends JpaRepository<OrderItemCommandEntity,
        String> {
}
