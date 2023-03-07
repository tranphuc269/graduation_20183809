package com.bookstore.orderservice.application.es.cart.command.api.events.handler;


import com.bookstore.orderservice.application.es.cart.command.api.events.CreateCartEvent;
import com.bookstore.orderservice.application.es.cart.command.api.events.RemoveAllCartItemEvent;

public interface ICartEventHandler {

    public void on(CreateCartEvent event);

    public void on(RemoveAllCartItemEvent event);

}
