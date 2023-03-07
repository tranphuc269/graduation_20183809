package com.bookstore.paymentservice.application.dto.request;

import com.bookstore.paymentservice.utils.PaymentProviderType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Builder
@Setter
public class PaymentCODRequest extends PaymentRequest {

    @Override
    public PaymentProviderType getPaymentProviderType() {
        return PaymentProviderType.COD;
    }



}