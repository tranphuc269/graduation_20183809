package com.bookstore.catalogservice.application.es.review.command.api.aggregate;


import com.bookstore.catalogservice.application.es.review.command.api.commands.CreateReviewCommand;
import com.bookstore.catalogservice.application.es.review.command.api.commands.DeleteReviewCommand;
import com.bookstore.catalogservice.application.es.review.command.api.commands.UpdateReviewCommand;
import com.bookstore.catalogservice.application.es.review.command.api.event.CreateReviewEvent;
import com.bookstore.catalogservice.application.es.review.command.api.event.DeleteReviewEvent;
import com.bookstore.catalogservice.application.es.review.command.api.event.UpdateReviewEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class ReviewAggregate {

    @AggregateIdentifier
    private String identity;

    private String reviewId;

    private String productId;

    private String userId;

    private double ratingValue;

    private String reviewContent;

    public ReviewAggregate(){}

    // create review
    @CommandHandler
    public ReviewAggregate(CreateReviewCommand command){
        CreateReviewEvent event = CreateReviewEvent
                .builder()
                .productId(command.getProductId())
                .userId(command.getUserId())
                .ratingValue(command.getRatingValue())
                .reviewContent(command.getReviewContent())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateReviewEvent event){
        this.identity = UUID.randomUUID().toString();
        this.productId = event.getProductId();
        this.userId = event.getUserId();
        this.reviewContent = event.getReviewContent();
        this.ratingValue = event.getRatingValue();
    }

    // update review
    @CommandHandler
    public ReviewAggregate(UpdateReviewCommand command){
        UpdateReviewEvent event = UpdateReviewEvent
                .builder()
                .reviewId(command.getReviewId())
                .productId(command.getProductId())
                .userId(command.getUserId())
                .ratingValue(command.getRatingValue())
                .reviewContent(command.getReviewContent())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateReviewEvent event){
        this.identity = UUID.randomUUID().toString();
        this.reviewId = event.getReviewId();
        this.productId = event.getProductId();
        this.userId = event.getUserId();
        this.reviewContent = event.getReviewContent();
        this.ratingValue = event.getRatingValue();
    }

    // delete review
    @CommandHandler
    public ReviewAggregate(DeleteReviewCommand command){
        DeleteReviewEvent event = DeleteReviewEvent
                .builder()
                .reviewId(command.getReviewId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DeleteReviewEvent event){
        this.identity = UUID.randomUUID().toString();
        this.reviewId = event.getReviewId();
    }


}
