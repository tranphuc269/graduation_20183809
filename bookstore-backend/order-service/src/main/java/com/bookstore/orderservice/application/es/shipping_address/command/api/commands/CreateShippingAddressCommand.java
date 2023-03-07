package com.bookstore.orderservice.application.es.shipping_address.command.api.commands;

import com.bookstore.orderservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateShippingAddressCommand extends BaseCommand<String> {
    private String city;
    private String detail;
    private String district;
    private String orderId;
    private String phoneNumber;
    private String province;
    private String userId;
    private String userName;

    public CreateShippingAddressCommand(String id,
                                        String city,
                                        String detail,
                                        String district,
                                        String orderId,
                                        String phoneNumber,
                                        String province,
                                        String userName,
                                        String userId) {
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
