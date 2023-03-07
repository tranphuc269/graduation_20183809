package com.bookstore.catalogservice.application.es.review.command.api.commands;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class CreateReviewCommand {
    private String productId;

    private String userId;

    private double ratingValue;

    private String reviewContent;
}
