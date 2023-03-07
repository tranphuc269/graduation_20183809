package com.bookstore.catalogservice.application.es.review.command.write_model;

import com.bookstore.catalogservice.application.es.review.command.write_model.entity.ReviewCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewCommandRepository extends JpaRepository<ReviewCommandEntity, String> {
}
