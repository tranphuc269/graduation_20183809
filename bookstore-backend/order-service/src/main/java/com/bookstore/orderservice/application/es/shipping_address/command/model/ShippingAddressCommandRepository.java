package com.bookstore.orderservice.application.es.shipping_address.command.model;

import com.bookstore.orderservice.application.es.shipping_address.command.model.entity.ShippingAddressCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressCommandRepository extends JpaRepository<ShippingAddressCommandEntity,
        String> {
}
