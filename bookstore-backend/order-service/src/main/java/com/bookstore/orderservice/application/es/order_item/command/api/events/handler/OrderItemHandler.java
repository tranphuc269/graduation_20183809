package com.bookstore.orderservice.application.es.order_item.command.api.events.handler;

import com.bookstore.orderservice.application.es.order_item.command.api.events.CreateOrderItemEvent;
import com.bookstore.orderservice.application.es.order_item.command.model.OrderItemCommandRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class OrderItemHandler implements IOrderItemHandler {

    @Autowired
    private OrderItemCommandRepository repository;


    @EventHandler
    @Override
    public void on(CreateOrderItemEvent event) {
        event.getEntities().forEach(cart -> {
            cart.setCreateTime(new Date());
            cart.setUpdateTime(new Date());
            cart.setStatus(1);
        });
        repository.saveAll(event.getEntities());
    }
}
