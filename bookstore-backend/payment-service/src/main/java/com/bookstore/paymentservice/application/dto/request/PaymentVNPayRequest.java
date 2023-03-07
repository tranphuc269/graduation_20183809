package com.bookstore.paymentservice.application.dto.request;

import com.bookstore.paymentservice.utils.PaymentProviderType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;


@Builder
@Getter
@Setter
public class PaymentVNPayRequest extends PaymentRequest{
    @Override
    public PaymentProviderType getPaymentProviderType() {
        return PaymentProviderType.VNPAY;
    }

    private int amount;
    private String description;
    @Nullable
    private String ipAddress;
}
