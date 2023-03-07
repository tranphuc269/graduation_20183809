package com.bookstore.catalogservice.application.es.review.command.api.commands;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class DeleteReviewCommand {
    private String reviewId;
}
