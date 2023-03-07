package com.bookstore.catalogservice.application.es.product.command.api.commands;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Getter
@Setter
public class SellProductCommand {

    @TargetAggregateIdentifier
    private String id;

    private String productId;
    private int quantity;
}
