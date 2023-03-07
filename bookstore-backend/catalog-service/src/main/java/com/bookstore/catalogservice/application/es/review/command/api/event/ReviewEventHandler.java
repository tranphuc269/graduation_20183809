package com.bookstore.catalogservice.application.es.review.command.api.event;

import com.bookstore.catalogservice.application.es.review.command.write_model.ReviewCommandRepository;
import com.bookstore.catalogservice.application.es.review.command.write_model.entity.ReviewCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


@Component
public class ReviewEventHandler implements IReviewEventHandler{

    @Autowired
    private ReviewCommandRepository repository;


    @EventHandler
    @Override
    public void on(CreateReviewEvent event) {
        ReviewCommandEntity reviewCommand = ReviewCommandEntity
                .builder()
                .productId(event.getProductId())
                .userId(event.getUserId())
                .reviewContent(event.getReviewContent())
                .ratingValue(event.getRatingValue())
                .build();
        reviewCommand.setCreateTime(new Date());
        reviewCommand.setUpdateTime(new Date());
        reviewCommand.setStatus(1);
        repository.save(reviewCommand);
    }


    @EventHandler
    @Override
    public void on(UpdateReviewEvent event) {
        System.out.println("event : " + event.getReviewId());
        Optional<ReviewCommandEntity>
                reviewCommand = repository
                .findById(event.getReviewId());
//        if(reviewCommand.isEmpty()){
//            throw new ExceptionCommon(new BusinessError(404,
//                    "Not found review", HttpStatus.NOT_FOUND));
//        }
        reviewCommand.get().setReviewContent(event.getReviewContent());
        reviewCommand.get().setUpdateTime(new Date());
        reviewCommand.get().setStatus(1);
        reviewCommand.get().setRatingValue(event.getRatingValue());

        repository.save(reviewCommand.get());
    }

    @EventHandler
    @Override
    public void on(DeleteReviewEvent event) {
        Optional<ReviewCommandEntity>
                reviewCommand = repository
                .findById(event.getReviewId());
//        if(reviewCommand.isEmpty()){
//            throw new ExceptionCommon(new BusinessError(404,
//                    "Not found review", HttpStatus.NOT_FOUND));
//        }
        reviewCommand.get().setStatus(0);
        repository.save(reviewCommand.get());
    }
}
