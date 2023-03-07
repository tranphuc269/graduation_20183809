package com.bookstore.catalogservice.application.es.review.command.write_model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class DeleteReviewRequest {
   private String reviewId;
}
