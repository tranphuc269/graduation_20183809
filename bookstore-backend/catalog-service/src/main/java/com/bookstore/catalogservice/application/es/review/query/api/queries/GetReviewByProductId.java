package com.bookstore.catalogservice.application.es.review.query.api.queries;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class GetReviewByProductId {
    private String productId;
}
