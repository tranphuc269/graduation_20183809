package com.bookstore.orderservice.application.client.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CreateVNPayRequest {
    private double amount;
    private String description;
}
