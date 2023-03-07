package com.bookstore.orderservice.application.es.shipping_address.command.api.events;

import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Setter
@Getter
public class CreateShippingAddressEvent extends BaseEvent<String> {
    private String city;

    private String detail;

    private String district;

    private String orderId;

    private String phoneNumber;

    private String province;

    private String userId;

    private String userName;

    public CreateShippingAddressEvent(String id,
                                      String city,
                                      String detail,
                                      String district,
                                      String orderId,
                                      String phoneNumber,
                                      String province,
                                      String userId,
                                      String userName
    ) {
        super(id);
        this.city = city;
        this.detail = detail;
        this.district = district;
        this.orderId = orderId;
        this.phoneNumber = phoneNumber;
        this.province = province;
        this.userId = userId;
        this.userName = userName;
    }
}
