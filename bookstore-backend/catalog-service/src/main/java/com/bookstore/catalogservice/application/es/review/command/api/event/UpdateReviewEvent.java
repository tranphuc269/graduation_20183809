package com.bookstore.catalogservice.application.es.review.command.api.event;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class UpdateReviewEvent {
    private String reviewId;
    private String productId;

    private String userId;

    private double ratingValue;

    private String reviewContent;
}
