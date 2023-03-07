package com.bookstore.catalogservice.application.es.review.command.api.controller;


import com.bookstore.catalogservice.application.es.review.command.api.commands.CreateReviewCommand;
import com.bookstore.catalogservice.application.es.review.command.api.commands.DeleteReviewCommand;
import com.bookstore.catalogservice.application.es.review.command.api.commands.UpdateReviewCommand;
import com.bookstore.catalogservice.application.es.review.command.write_model.request.CreateReviewRequest;
import com.bookstore.catalogservice.application.es.review.command.write_model.request.UpdateReviewRequest;
import com.bookstore.catalogservice.application.es.review.command.write_model.request.DeleteReviewRequest;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/review")
public class ReviewCommandController {

    @Autowired
    private CommandGateway gateway;

    @PostMapping
    public BaseResponse<Void> createReview(@RequestBody CreateReviewRequest request){
        CreateReviewCommand command = CreateReviewCommand
                .builder()
                .productId(request.getProductId())
                .userId(request.getUserId())
                .reviewContent(request.getReviewContent())
                .ratingValue(request.getRatingValue())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PutMapping
    public BaseResponse<Void> updateReview(@RequestBody UpdateReviewRequest request){
        UpdateReviewCommand command = UpdateReviewCommand
                .builder()
                .reviewId(request.getReviewId())
                .productId(request.getProductId())
                .userId(request.getUserId())
                .reviewContent(request.getReviewContent())
                .ratingValue(request.getRatingValue())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @DeleteMapping("/{reviewId}")
    public BaseResponse<Void> deleteReview(@PathVariable String reviewId){
        DeleteReviewRequest request = DeleteReviewRequest
                .builder()
                .reviewId(reviewId)
                .build();
        DeleteReviewCommand command = DeleteReviewCommand
                .builder()
                .reviewId(request.getReviewId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

}
