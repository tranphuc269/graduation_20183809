package com.bookstore.catalogservice.application.es.attribute.command.api.aggregate;


import com.bookstore.catalogservice.application.es.attribute.command.api.events.attribute.CreateAttributeEvent;
import com.bookstore.catalogservice.application.es.attribute.command.api.commands.CreateAttributeCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AttributeAggregate {


    @AggregateIdentifier
    private String attributeId;
    private String name;

    public AttributeAggregate() {
    }

    @CommandHandler
    public AttributeAggregate(CreateAttributeCommand command){
        CreateAttributeEvent event = CreateAttributeEvent
                .builder()
                .attributeId(command.getAttributeId())
                .name(command.getName())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateAttributeEvent event){
        this.attributeId = event.getAttributeId();
        this.name = event.getName();
    }
}
