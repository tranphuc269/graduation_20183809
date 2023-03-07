package com.bookstore.orderservice.application.client.service;

import com.bookstore.orderservice.application.client.model.VNPayResponseClient;
import com.bookstore.orderservice.application.client.model.request.CreateVNPayRequest;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantity;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantityResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IWebClient {
    VNPayResponseClient createPayment(CreateVNPayRequest request, String bearToken);

    List<CheckProductQuantityResponse> checkProductQuantity(List<CheckProductQuantity> request, String bearToken);
}
