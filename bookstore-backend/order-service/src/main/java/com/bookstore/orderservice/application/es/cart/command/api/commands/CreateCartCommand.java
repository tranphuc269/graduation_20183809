package com.bookstore.orderservice.application.es.cart.command.api.commands;

import com.bookstore.orderservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
public class CreateCartCommand extends BaseCommand<String> {
    private String userId;

    public CreateCartCommand(String id, String userId) {
        super(id);
        this.userId = userId;
    }
}
