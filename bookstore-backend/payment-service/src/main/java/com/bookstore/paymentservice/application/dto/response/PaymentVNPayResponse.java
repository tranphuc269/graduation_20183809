package com.bookstore.paymentservice.application.dto.response;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@Data
public class PaymentVNPayResponse extends PaymentResponse{
    private String status;
    private String message;
    private String url;
}
