package com.bookstore.catalogservice.application.es.attribute.repository;

import com.bookstore.catalogservice.application.es.attribute.command.write_data.entity.AttributeValueModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttributeValueRepository extends JpaRepository<AttributeValueModel, String> {
    List<AttributeValueModel> getAttributeValueModelsByProductId(String productId);
}
