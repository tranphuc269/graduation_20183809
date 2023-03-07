package com.bookstore.catalogservice.application.es.review.query.api.controller;


import com.bookstore.catalogservice.application.es.review.query.api.queries.GetReviewByProductId;
import com.bookstore.catalogservice.application.es.review.query.read_model.response.ReviewResponse;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/review")
public class ReviewQueryController {
    @Autowired
    private QueryGateway gateway;

    @GetMapping("{productId}")
    public BaseResponse<List<ReviewResponse>> getReviewByProductId(@PathVariable String productId) {
        GetReviewByProductId query = GetReviewByProductId
                .builder()
                .productId(productId)
                .build();
        return BaseResponse
                .ofSucceeded(
                        gateway
                                .query(query,
                                        ResponseTypes.multipleInstancesOf(ReviewResponse.class))
                                .join());
    }
}
