package com.bookstore.orderservice.application.es.cart_item.command.api.events;

import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveCartItemEvent extends BaseEvent<String> {
    private String cartItemId;

    public RemoveCartItemEvent(String id, String cartItemId) {
        super(id);
        this.cartItemId = cartItemId;
    }


}
