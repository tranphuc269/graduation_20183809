package com.bookstore.catalogservice.application.es.product.command.write_model;

import com.bookstore.catalogservice.application.es.product.command.write_model.entity.ProductCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductCommandRepository
        extends JpaRepository<ProductCommandEntity, String> {
}
