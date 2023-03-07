package com.bookstore.catalogservice.application.es.attribute.command.api.commands;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@Getter
@Setter
@Builder
public class CreateAttributeValueCommand {

    @TargetAggregateIdentifier
    private String attributeValueId;
    private String attributeId;

    private String value;

    private String productId;
}
