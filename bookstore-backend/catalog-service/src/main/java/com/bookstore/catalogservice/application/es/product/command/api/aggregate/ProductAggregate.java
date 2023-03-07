package com.bookstore.catalogservice.application.es.product.command.api.aggregate;


import com.bookstore.catalogservice.application.es.product.command.api.commands.*;
import com.bookstore.catalogservice.application.es.product.command.api.events.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;


import java.util.UUID;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String identity;

    private String productId;

    private String name;

    private String shortContent;

    private String description;

    private double price;

    private int availableItemCount;

    private String images;

    private int status;

    private int quantitySold;

    private String authorId;

    private String categoryId;

    public ProductAggregate() {
    }


    // create product
    @CommandHandler
    public ProductAggregate(CreateProductCommand command) {
        CreateProductEvent event = CreateProductEvent
                .builder()
                .name(command.getName())
                .shortContent(command.getShortContent())
                .description(command.getDescription())
                .price(command.getPrice())
                .availableItemCount(command.getAvailableItemCount())
                .images(command.getImages())
                .quantitySold(0)
                .authorId(command.getAuthorId())
                .categoryId(command.getCategoryId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateProductEvent event) {
        this.identity = UUID.randomUUID().toString();
        this.name = event.getName();
        this.shortContent = event.getShortContent();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.availableItemCount = event.getAvailableItemCount();
        this.images = event.getImages();
        this.status = 1;
        this.quantitySold = 0;
        this.authorId = event.getAuthorId();
        this.categoryId = event.getCategoryId();
    }

    // update product
    @CommandHandler
    public ProductAggregate(UpdateProductCommand command) {
        UpdateProductEvent event = UpdateProductEvent
                .builder()
                .productId(command.getProductId())
                .name(command.getName())
                .shortContent(command.getShortContent())
                .description(command.getDescription())
                .price(command.getPrice())
                .availableItemCount(command.getAvailableItemCount())
                .images(command.getImages())
                .authorId(command.getAuthorId())
                .categoryId(command.getCategoryId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateProductEvent event) {
        this.identity = UUID.randomUUID().toString();
        this.productId = event.getProductId();
        this.name = event.getName();
        this.shortContent = event.getShortContent();
        this.description = event.getDescription();
        this.price = event.getPrice();
        this.availableItemCount = event.getAvailableItemCount();
        this.images = event.getImages();
        this.status = 1;
        this.categoryId = event.getCategoryId();
        this.authorId = event.getAuthorId();
    }

    // delete product
    @CommandHandler
    public ProductAggregate(DeleteProductCommand command) {
        DeleteProductEvent event = DeleteProductEvent
                .builder()
                .productId(command.getProductId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DeleteProductEvent event) {
        this.status = 0;
        this.identity = UUID.randomUUID().toString();
        this.productId = event.getProductId();
    }

    // enable product
    @CommandHandler
    public ProductAggregate(EnableProductCommand command) {
        EnableProductEvent event = EnableProductEvent
                .builder()
                .productId(command.getProductId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(EnableProductEvent event) {
        this.status = 1;
        this.identity = UUID.randomUUID().toString();
        this.productId = event.getProductId();
    }

    // sell product
    @CommandHandler
    public ProductAggregate(SellProductCommand command) {
        SellProductEvent event = SellProductEvent
                .builder()
                .id(command.getId())
                .productId(command.getProductId())
                .quantity(command.getQuantity())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(SellProductEvent event){
        this.identity = event.getId();
        this.quantitySold = event.getQuantity();
        this.productId = event.getProductId();
    }



}