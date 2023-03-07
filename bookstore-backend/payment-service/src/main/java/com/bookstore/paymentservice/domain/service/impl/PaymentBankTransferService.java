package com.bookstore.paymentservice.domain.service.impl;

import com.bookstore.paymentservice.application.dto.request.PaymentBankTransferRequest;
import com.bookstore.paymentservice.application.dto.response.PaymentBankTransferResponse;
import com.bookstore.paymentservice.domain.service.PaymentService;
import org.springframework.stereotype.Component;

@Component
public class PaymentBankTransferService
        implements PaymentService<PaymentBankTransferRequest, PaymentBankTransferResponse> {
    @Override
    public PaymentBankTransferResponse pay(PaymentBankTransferRequest request) {
        return null;
    }
}
