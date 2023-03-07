package com.bookstore.orderservice.application.es.cart_item.command.api.events;

import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AddCartItemEvent extends BaseEvent<String> {
    private String cartId;
    private int quantity;
    private String productId;
    private String productName;
    private String images;
    private String productShortDescription;

    private double productPrice;

    public AddCartItemEvent(String id,
                            String cartId,
                            String productId,
                            String productName,
                            String productShortDescription,
                            String images,
                            double productPrice) {
        super(id);
        this.quantity = 1;
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.productShortDescription = productShortDescription;
        this.images = images;
        this.productPrice = productPrice;
    }
}
