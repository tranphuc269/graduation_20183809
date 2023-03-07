package com.bookstore.paymentservice.domain.provider;

import com.bookstore.paymentservice.utils.PaymentProviderType;

public interface PaymentProvider<T> {
    T getProvider(PaymentProviderType type);
}