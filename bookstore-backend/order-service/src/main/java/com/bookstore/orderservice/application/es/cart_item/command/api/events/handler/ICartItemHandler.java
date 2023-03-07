package com.bookstore.orderservice.application.es.cart_item.command.api.events.handler;

import com.bookstore.orderservice.application.es.cart_item.command.api.events.AddCartItemEvent;
import com.bookstore.orderservice.application.es.cart_item.command.api.events.RemoveAllCartItemEvent;
import com.bookstore.orderservice.application.es.cart_item.command.api.events.RemoveCartItemEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Service;


@Service
public interface ICartItemHandler {

    public void on(AddCartItemEvent event);


    public void on(RemoveCartItemEvent event);


    public void on(RemoveAllCartItemEvent event);
}
