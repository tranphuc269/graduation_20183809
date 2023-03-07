package com.bookstore.orderservice.application.es.order_item.command.api.events;

import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import com.bookstore.orderservice.application.es.order_item.command.model.entity.OrderItemCommandEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CreateOrderItemEvent extends BaseEvent<String> {

    private List<OrderItemCommandEntity> entities;

    public CreateOrderItemEvent(String id, List<OrderItemCommandEntity> entities) {
        super(id);
        this.entities = entities;
    }
}
