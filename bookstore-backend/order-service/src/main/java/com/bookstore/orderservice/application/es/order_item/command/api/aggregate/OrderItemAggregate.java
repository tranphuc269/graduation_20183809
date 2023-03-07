package com.bookstore.orderservice.application.es.order_item.command.api.aggregate;


import com.bookstore.orderservice.application.es.order_item.command.api.commands.CreateOrderItemCommand;
import com.bookstore.orderservice.application.es.order_item.command.api.events.CreateOrderItemEvent;
import com.bookstore.orderservice.application.es.order_item.command.model.entity.OrderItemCommandEntity;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;

@Aggregate
public class OrderItemAggregate {
    @AggregateIdentifier
    private String id;

    private List<OrderItemCommandEntity> entities;

    public OrderItemAggregate() {
    }

    // create order items
    @CommandHandler
    public OrderItemAggregate(CreateOrderItemCommand command){
        CreateOrderItemEvent event = new CreateOrderItemEvent(command.id,
                command.getEntities());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateOrderItemEvent event){
        this.id = event.id;
        this.entities = event.getEntities();
    }

}
