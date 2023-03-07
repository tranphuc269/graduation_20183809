package com.bookstore.orderservice.application.es.shipping_address.query.api.projection;


import com.bookstore.orderservice.application.es.shipping_address.query.api.queries.GetAddressByOrderIdQuery;
import com.bookstore.orderservice.application.es.shipping_address.query.model.dto.ShippingAddressResponse;
import com.bookstore.orderservice.application.es.shipping_address.query.model.ShippingAddressQueryRepository;
import com.bookstore.orderservice.application.es.shipping_address.query.model.entity.ShippingAddressQueryEntity;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShippingAddressProjection {

    @Autowired
    private ShippingAddressQueryRepository repository;

    @QueryHandler
    public ShippingAddressResponse handle(GetAddressByOrderIdQuery query){
        ShippingAddressQueryEntity entity = repository.findByOrderId(query.getOrderId()).get();
        return ShippingAddressResponse
                .builder()
                .addressId(entity.getAddressId())
                .orderId(entity.getOrderId())
                .detail(entity.getDetail())
                .userId(entity.getUserId())
                .city(entity.getCity())
                .phoneNumber(entity.getPhoneNumber())
                .province(entity.getProvince())
                .district(entity.getDistrict())
                .userName(entity.getUserName())
                .build();
    }
}
