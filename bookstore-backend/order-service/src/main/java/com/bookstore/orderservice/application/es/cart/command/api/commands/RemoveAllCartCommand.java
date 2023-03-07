package com.bookstore.orderservice.application.es.cart.command.api.commands;

import com.bookstore.orderservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RemoveAllCartCommand extends BaseCommand<String> {
    private String cartId;
    public RemoveAllCartCommand(String id, String userId) {
        super(id);
        this.cartId = userId;
    }
}
