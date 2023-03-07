package com.bookstore.catalogservice.application.es.review.command.api.commands;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class UpdateReviewCommand {
    private String reviewId;
    private String productId;

    private String userId;

    private String userName;

    private double ratingValue;

    private String reviewContent;
}
