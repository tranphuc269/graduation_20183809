package com.bookstore.paymentservice.domain.service;

import com.bookstore.paymentservice.application.dto.request.PaymentRequest;
import com.bookstore.paymentservice.application.dto.response.PaymentResponse;

import java.io.UnsupportedEncodingException;

public interface PaymentService<T extends PaymentRequest, R extends PaymentResponse> {
    R pay(T request) throws UnsupportedEncodingException;
}