package com.bookstore.orderservice.application.es.order.service;

import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantityResponse;

import java.util.List;

public interface IOrderService {
   List<CheckProductQuantityResponse> checkProductQuantity(String cartId, String bearToken);
}
