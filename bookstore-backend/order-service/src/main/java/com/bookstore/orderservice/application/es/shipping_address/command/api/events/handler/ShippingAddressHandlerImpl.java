package com.bookstore.orderservice.application.es.shipping_address.command.api.events.handler;

import com.bookstore.orderservice.application.es.shipping_address.command.api.events.CreateShippingAddressEvent;
import com.bookstore.orderservice.application.es.shipping_address.command.model.ShippingAddressCommandRepository;
import com.bookstore.orderservice.application.es.shipping_address.command.model.entity.ShippingAddressCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ShippingAddressHandlerImpl implements IShippingAddressHandler{

    @Autowired
    private ShippingAddressCommandRepository repository;

    @EventHandler
    @Override
    public void on(CreateShippingAddressEvent event) {
        ShippingAddressCommandEntity entity = ShippingAddressCommandEntity
                .builder()
                .city(event.getCity())
                .detail(event.getDetail())
                .district(event.getDistrict())
                .orderId(event.getOrderId())
                .phoneNumber(event.getPhoneNumber())
                .province(event.getProvince())
                .userId(event.getUserId())
                .userName(event.getUserName())
                .build();
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setStatus(1);
        repository.save(entity);
    }
}
