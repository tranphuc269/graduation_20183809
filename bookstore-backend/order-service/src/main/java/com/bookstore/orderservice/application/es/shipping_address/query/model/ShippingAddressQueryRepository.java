package com.bookstore.orderservice.application.es.shipping_address.query.model;

import com.bookstore.orderservice.application.es.shipping_address.query.model.entity.ShippingAddressQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ShippingAddressQueryRepository extends JpaRepository<ShippingAddressQueryEntity,
        String> {

    Optional<ShippingAddressQueryEntity> findByOrderId(String orderId);
}
