package com.bookstore.orderservice.application.es.order_item.command.api.commands;

import com.bookstore.orderservice.common.infrastructure.axon.BaseCommand;
import com.bookstore.orderservice.application.es.order_item.command.model.entity.OrderItemCommandEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CreateOrderItemCommand extends BaseCommand<String> {
    private List<OrderItemCommandEntity> entities;

    public CreateOrderItemCommand(String id, List<OrderItemCommandEntity> entities) {
        super(id);
        this.entities = entities;
    }
}
