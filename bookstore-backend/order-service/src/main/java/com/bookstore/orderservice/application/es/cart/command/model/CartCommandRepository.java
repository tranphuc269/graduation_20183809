package com.bookstore.orderservice.application.es.cart.command.model;

import com.bookstore.orderservice.application.es.cart.command.model.entity.CartCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CartCommandRepository extends CrudRepository<CartCommandEntity, String> {
}
