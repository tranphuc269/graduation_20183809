package com.bookstore.catalogservice.application.es.author.command.api.aggregate;

import com.bookstore.catalogservice.application.es.author.command.api.commands.CreateAuthorCommand;
import com.bookstore.catalogservice.application.es.author.command.api.commands.DeleteAuthorCommand;
import com.bookstore.catalogservice.application.es.author.command.api.commands.EnableAuthorCommand;
import com.bookstore.catalogservice.application.es.author.command.api.events.CreateAuthorEvent;
import com.bookstore.catalogservice.application.es.author.command.api.events.DeleteAuthorEvent;
import com.bookstore.catalogservice.application.es.author.command.api.events.EnableAuthorEvent;
import com.bookstore.catalogservice.application.es.author.command.api.events.UpdateAuthorEvent;
import com.bookstore.catalogservice.application.es.author.command.api.commands.UpdateAuthorCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class AuthorAggregate {
    @AggregateIdentifier
    private String identity;
    private String authorId;
    private String name;
    private String images;

    private String description;

    private int status;

    public AuthorAggregate() {
    }

    // create author
    @CommandHandler
    public AuthorAggregate(CreateAuthorCommand command) {
        CreateAuthorEvent event = CreateAuthorEvent
                .builder()
                .authorName(command.getAuthorName())
                .identity(command.getIdentity())
                .description(command.getDescription())
                .images(command.getImages())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateAuthorEvent event) {
        this.identity = event.getIdentity();
        this.authorId = null;
        this.images = event.getImages();
        this.name = event.getAuthorName();
        this.status = 1;
        this.description = event.getDescription();
    }

    // update author

    @CommandHandler
    public AuthorAggregate(UpdateAuthorCommand command) {
        UpdateAuthorEvent event = UpdateAuthorEvent
                .builder()
                .authorId(command.getAuthorId())
                .authorName(command.getAuthorName())
                .images(command.getImages())
                .description(command.getDescription())
                .status(1)
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateAuthorEvent event) {
        this.status = 1;
        this.name = event.getAuthorName();
        this.identity = UUID.randomUUID().toString();
        this.images = event.getImages();
        this.description = event.getDescription();
    }

    // delete author
    @CommandHandler
    public AuthorAggregate(DeleteAuthorCommand command) {
        DeleteAuthorEvent event = DeleteAuthorEvent
                .builder()
                .authorId(command.getAuthorId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DeleteAuthorEvent event) {
        this.authorId = event.getAuthorId();
        this.identity = UUID.randomUUID().toString();
        this.status = 0;
    }

    // enable author
    @CommandHandler
    public AuthorAggregate(EnableAuthorCommand command) {
        EnableAuthorEvent event = EnableAuthorEvent
                .builder()
                .authorId(command.getAuthorId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EnableAuthorEvent event) {
        this.authorId = event.getAuthorId();
        this.identity = UUID.randomUUID().toString();
        this.status = 1;
    }

}
