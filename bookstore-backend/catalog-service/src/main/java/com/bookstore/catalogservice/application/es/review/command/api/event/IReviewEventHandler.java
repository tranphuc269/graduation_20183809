package com.bookstore.catalogservice.application.es.review.command.api.event;

public interface IReviewEventHandler {
    public void on(CreateReviewEvent event);
    public void on(UpdateReviewEvent event);
    public void on(DeleteReviewEvent event);
}
