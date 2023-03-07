package com.bookstore.orderservice.application.es.shipping_address.query.model.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingAddressResponse {
    private String addressId;
    private String city;

    private String detail;

    private String district;

    private String orderId;

    private String phoneNumber;

    private String province;

    private String userId;

    private String userName;
}
