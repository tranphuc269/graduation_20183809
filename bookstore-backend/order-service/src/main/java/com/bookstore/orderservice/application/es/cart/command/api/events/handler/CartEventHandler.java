package com.bookstore.orderservice.application.es.cart.command.api.events.handler;

import com.bookstore.orderservice.application.es.cart.command.api.events.CreateCartEvent;
import com.bookstore.orderservice.application.es.cart.command.api.events.RemoveAllCartItemEvent;
import com.bookstore.orderservice.application.es.cart.command.model.CartCommandRepository;
import com.bookstore.orderservice.application.es.cart.command.model.entity.CartCommandEntity;
import com.bookstore.orderservice.application.es.cart_item.command.api.commands.RemoveAllCartItemCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.UUID;

@Component
public class CartEventHandler implements ICartEventHandler {
    @Autowired
    private CartCommandRepository cartRepository;

    @Autowired
    private CommandGateway commandGateway;


    @EventHandler
    @Override
    public void on(CreateCartEvent event) {
        CartCommandEntity entity = CartCommandEntity
                .builder()
                .userId(event.getUserId())
                .build();
        entity.setCreateTime(new Date());
        entity.setStatus(1);
        entity.setUpdateTime(new Date());
        cartRepository.save(entity);
    }

    @EventHandler
    @Override
    public void on(RemoveAllCartItemEvent event) {
        commandGateway.send(new RemoveAllCartItemCommand(UUID.randomUUID().toString(),
                event.getCartId()));
    }
}
