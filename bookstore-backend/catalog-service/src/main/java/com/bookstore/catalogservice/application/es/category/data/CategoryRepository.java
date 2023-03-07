package com.bookstore.catalogservice.application.es.category.data;

import com.bookstore.catalogservice.application.es.category.data.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, String> {
}
