package com.bookstore.catalogservice.application.es.product.query.read_model.specifications;

import com.bookstore.catalogservice.application.es.product.query.read_model.entity.ProductQueryEntity;
import com.bookstore.catalogservice.application.es.product.utils.ProductConstant;
import org.springframework.data.jpa.domain.Specification;

public class ProductQuerySpecification {
    public static Specification<ProductQueryEntity> hasCategoryId(String categoryId) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(ProductConstant.CATEGORY_ID), categoryId);
        }));
    }

    public static Specification<ProductQueryEntity> hasAuthorId(String authorId) {
        return (((root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(ProductConstant.AUTHOR_ID), authorId);
        }));
    }
}
