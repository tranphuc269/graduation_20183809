package com.bookstore.paymentservice.application.gateway.impl;

import com.bookstore.paymentservice.application.dto.request.PaymentRequest;
import com.bookstore.paymentservice.application.dto.response.PaymentResponse;
import com.bookstore.paymentservice.application.gateway.PaymentGateway;
import com.bookstore.paymentservice.domain.provider.PaymentProvider;
import com.bookstore.paymentservice.domain.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
@RequiredArgsConstructor
public class DefaultPaymentGatewayImpl implements PaymentGateway<PaymentResponse, PaymentRequest> {
    private final PaymentProvider<PaymentService<PaymentRequest, PaymentResponse>> paymentProvider;

    @Override
    public PaymentResponse makePayment(PaymentRequest paymentRequest) throws UnsupportedEncodingException {
        return paymentProvider.getProvider(paymentRequest.getPaymentProviderType()).pay(paymentRequest);
    }
}