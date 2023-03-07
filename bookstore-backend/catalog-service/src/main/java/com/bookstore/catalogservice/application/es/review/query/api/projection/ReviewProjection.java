package com.bookstore.catalogservice.application.es.review.query.api.projection;

import com.bookstore.catalogservice.application.es.review.query.read_model.ReviewQueryRepository;
import com.bookstore.catalogservice.application.es.review.query.read_model.response.ReviewResponse;
import com.bookstore.catalogservice.application.es.review.query.api.queries.GetReviewByProductId;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewProjection {
    @Autowired
    private ReviewQueryRepository repository;


    @QueryHandler
    public List<ReviewResponse> handle(GetReviewByProductId query){
        return repository
                .findAllByProductId(query.getProductId())
                .stream()
                .map(reviewQueryEntity ->
                        ReviewResponse
                                .builder()
                                .reviewId(reviewQueryEntity.getReviewId())
                                .productId(reviewQueryEntity.getProductId())
                                .userId(reviewQueryEntity.getUserId())
                                .reviewContent(reviewQueryEntity.getReviewContent())
                                .ratingValue(reviewQueryEntity.getRatingValue())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
