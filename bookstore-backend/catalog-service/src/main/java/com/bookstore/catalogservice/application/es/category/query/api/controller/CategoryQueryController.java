package com.bookstore.catalogservice.application.es.category.query.api.controller;


import com.bookstore.catalogservice.application.es.category.data.dto.CategoryResponse;
import com.bookstore.catalogservice.application.es.category.query.api.queries.GetCategoryQuery;
//import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/category")
public class CategoryQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping
    public BaseResponse<List<CategoryResponse>> getAllCategory() {
        GetCategoryQuery query = new GetCategoryQuery();
        return BaseResponse
                .ofSucceeded(
                        queryGateway
                                .query(query,
                                        ResponseTypes.multipleInstancesOf(CategoryResponse.class))
                                .join());
    }

}
