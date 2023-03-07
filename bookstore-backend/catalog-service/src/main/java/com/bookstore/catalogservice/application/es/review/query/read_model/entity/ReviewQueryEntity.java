package com.bookstore.catalogservice.application.es.review.query.read_model.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Entity
@Table(name = "reviews")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewQueryEntity {
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
