package com.bookstore.orderservice.application.es.cart_item.command.model.entity;


import com.bookstore.orderservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "cart_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CartItemCommandEntity extends BaseModel {

    @Id
    @GeneratedValue(generator="cart_item_id-uuid")
    @GenericGenerator(name="cart_item_id-uuid", strategy = "uuid")
    @Column(name = "cart_item_id", updatable = false, nullable = false)
    private String cartItemId;

    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;
    @Column(name = "product_price", updatable = false, nullable = false)
    private double productPrice;

    @Column(name = "product_name", updatable = false, nullable = false)
    private String productName;

    @Column(name = "product_short_content", updatable = false, nullable = false)
    private String productShortContent;

    @Column(name = "images", updatable = false, nullable = false)
    private String images;

    @Column(name = "cart_id", updatable = false, nullable = false)
    private String cartId;
    @Column(name = "quantity", updatable = false, nullable = false)
    private int quantity;


}
