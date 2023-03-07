package com.bookstore.orderservice.application.es.order_item.command.model.entity;

import com.bookstore.orderservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table(name = "order_items")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItemCommandEntity extends BaseModel {

    @Id
    @GeneratedValue(generator="cart_item_id-uuid")
    @GenericGenerator(name="cart_item_id-uuid", strategy = "uuid")
    @Column(name = "order_item_id", updatable = false, nullable = false)
    private String orderItemId;

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

    @Column(name = "order_id", updatable = false, nullable = false)
    private String orderId;
    @Column(name = "quantity", updatable = false, nullable = false)
    private int quantity;

}
