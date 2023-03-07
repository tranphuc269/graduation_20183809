package com.bookstore.orderservice.application.es.order.command.write_model.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CreateOrderShippingAddressRequest {
    private String city;
    private String detail;
    private String district;
    private String phoneNumber;
    private String province;
    private String userName;
}
