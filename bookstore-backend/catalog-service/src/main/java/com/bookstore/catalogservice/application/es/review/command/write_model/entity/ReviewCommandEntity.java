package com.bookstore.catalogservice.application.es.review.command.write_model.entity;

import com.bookstore.catalogservice.common.infrastructure.repo.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "reviews")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewCommandEntity extends BaseModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "review_id", updatable = false, nullable = false)
    private String reviewId;

    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "rating_value", nullable = false)
    @Min(1)
    @Max(5)
    private double ratingValue;

    @Column(name = "review_content", columnDefinition = "TEXT")
    private String reviewContent;
}
