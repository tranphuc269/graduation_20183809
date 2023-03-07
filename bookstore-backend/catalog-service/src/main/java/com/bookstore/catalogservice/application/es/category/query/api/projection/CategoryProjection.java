package com.bookstore.catalogservice.application.es.category.query.api.projection;


import com.bookstore.catalogservice.application.es.category.data.CategoryRepository;
import com.bookstore.catalogservice.application.es.category.data.dto.CategoryResponse;
import com.bookstore.catalogservice.application.es.category.data.model.CategoryModel;
import com.bookstore.catalogservice.application.es.category.query.api.queries.GetCategoryQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryProjection {
    @Autowired
    private CategoryRepository repository;

    @QueryHandler
    public List<CategoryResponse> handle(GetCategoryQuery query) {
        List<CategoryModel> categoryModels = repository.findAll();
        return categoryModels
                .stream()
                .map(categoryModel ->
                        CategoryResponse
                                .builder()
                                .categoryId(categoryModel.getCategoryId())
                                .categoryName(categoryModel.getCategoryName())
                                .description(categoryModel.getDescription())
                                .image(categoryModel.getImage())
                                .build())
                .collect(Collectors.toList());
    }
}
