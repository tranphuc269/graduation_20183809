package com.bookstore.orderservice.application.es.cart_item.command.api.commands;

import com.bookstore.orderservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RemoveAllCartItemCommand extends BaseCommand<String> {
    private String cartId;
    public RemoveAllCartItemCommand(String id, String cartId) {
        super(id);
        this.cartId = cartId;
    }
}
