package com.bookstore.catalogservice.application.es.review.command.write_model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@Builder
@Setter
@Getter
public class UpdateReviewRequest {
    private String reviewId;
    private String productId;

    private String userId;

    @Min(1)
    @Max(5)
    private double ratingValue;

    private String reviewContent;
}
