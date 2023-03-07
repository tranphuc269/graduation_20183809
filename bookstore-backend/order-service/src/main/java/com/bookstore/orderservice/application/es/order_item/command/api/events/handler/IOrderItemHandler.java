package com.bookstore.orderservice.application.es.order_item.command.api.events.handler;

import com.bookstore.orderservice.application.es.order_item.command.api.events.CreateOrderItemEvent;

public interface IOrderItemHandler {
    public void on(CreateOrderItemEvent event);
}
