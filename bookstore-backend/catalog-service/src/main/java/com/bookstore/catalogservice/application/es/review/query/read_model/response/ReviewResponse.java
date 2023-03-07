package com.bookstore.catalogservice.application.es.review.query.read_model.response;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
public class ReviewResponse {
    private String reviewId;

    private String productId;

    private String userId;

    private double ratingValue;

    private String reviewContent;
}
