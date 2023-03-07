package com.bookstore.catalogservice.application.es.review.command.api.event;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class CreateReviewEvent {
    private String productId;

    private String userId;

    private double ratingValue;

    private String reviewContent;
}
