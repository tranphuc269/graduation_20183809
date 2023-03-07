package com.bookstore.orderservice.application.es.order.command.write_model;

import com.bookstore.orderservice.application.es.order.command.write_model.entity.OrderCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface OrderCommandRepository extends JpaRepository<OrderCommandEntity, String> {
    public void deleteByOrderCheckingId(String orderCheckingId);
    Optional<OrderCommandEntity> getOrderCommandEntityByOrderCheckingId(String orderCheckingId);
}
