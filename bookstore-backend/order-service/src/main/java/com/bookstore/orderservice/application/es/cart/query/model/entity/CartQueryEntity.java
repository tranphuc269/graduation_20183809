package com.bookstore.orderservice.application.es.cart.query.model.entity;

import com.bookstore.orderservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartQueryEntity extends BaseModel {
    @Id
    @GeneratedValue(generator="cart-uuid")
    @GenericGenerator(name="cart-uuid", strategy = "uuid")
    @Column(name = "cart_id", updatable = false, nullable = false)
    private String cartId;

    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;
}
