package com.bookstore.orderservice.application.es.cart.command.api.events;

import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateCartEvent extends BaseEvent<String> {
    private String userId;
    public CreateCartEvent(String id, String userId) {
        super(id);
        this.userId = userId;
    }
}
