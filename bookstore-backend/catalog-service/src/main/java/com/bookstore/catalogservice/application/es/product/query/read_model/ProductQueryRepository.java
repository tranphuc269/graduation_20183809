package com.bookstore.catalogservice.application.es.product.query.read_model;

import com.bookstore.catalogservice.application.es.product.query.read_model.entity.ProductQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProductQueryRepository extends JpaRepository<ProductQueryEntity, String>,
        JpaSpecificationExecutor<ProductQueryEntity> {


    List<ProductQueryEntity> findByProductIdIn(List<String> productId);
}
