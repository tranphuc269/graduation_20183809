package com.bookstore.orderservice.application.es.cart.command.api.aggregate;


import com.bookstore.orderservice.application.es.cart.command.api.commands.CreateCartCommand;
import com.bookstore.orderservice.application.es.cart.command.api.commands.RemoveAllCartCommand;
import com.bookstore.orderservice.application.es.cart.command.api.events.CreateCartEvent;
import com.bookstore.orderservice.application.es.cart.command.api.events.RemoveAllCartItemEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class CartCommandAggregate {

    @AggregateIdentifier
    private String id;

    private String cartId;

    private String userId;

    public CartCommandAggregate() {
    }

    @CommandHandler
    public CartCommandAggregate(CreateCartCommand command) {
        CreateCartEvent event = new CreateCartEvent(UUID.randomUUID().toString(),
                command.getUserId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateCartEvent event) {
        this.userId = event.getUserId();
        this.id = event.getId();
    }

    // delete all
    @CommandHandler
    public CartCommandAggregate(RemoveAllCartCommand command) {
        RemoveAllCartItemEvent event = new RemoveAllCartItemEvent(UUID.randomUUID().toString(),
                command.getCartId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(RemoveAllCartItemEvent event) {
        this.cartId = event.getCartId();
        this.id = event.getId();
    }

}
