package com.bookstore.catalogservice.application.es.product.query.api.services;

import com.bookstore.catalogservice.application.es.product.query.read_model.query_request.CheckProductQuantity;
import com.bookstore.catalogservice.application.es.product.query.read_model.response.CheckProductQuantityResponse;

import java.util.List;

public interface IProductService {
    List<CheckProductQuantityResponse> checkProductQuantity(List<CheckProductQuantity> request);
}
