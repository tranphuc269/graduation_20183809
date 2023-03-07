package com.bookstore.paymentservice.application.dto.request;

import com.bookstore.paymentservice.utils.PaymentProviderType;

public abstract class PaymentRequest {
    // any common fields
    public abstract PaymentProviderType getPaymentProviderType();
}