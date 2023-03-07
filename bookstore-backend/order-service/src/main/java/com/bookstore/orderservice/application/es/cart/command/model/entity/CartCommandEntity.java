package com.bookstore.orderservice.application.es.cart.command.model.entity;
import com.bookstore.orderservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.*;


@Entity
@Table(name = "carts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartCommandEntity extends BaseModel {
    @Id
    @GeneratedValue(generator="cart-uuid")
    @GenericGenerator(name="cart-uuid", strategy = "uuid")
    @Column(name = "cart_id", updatable = false, nullable = false)
    private String cartId;

    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;
}
