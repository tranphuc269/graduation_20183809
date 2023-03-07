package com.bookstore.catalogservice.application.es.attribute.command.api.commands;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@Builder
@Setter
@Getter
public class CreateAttributeCommand {
    @TargetAggregateIdentifier
    private String attributeId;
    private String name;
}
