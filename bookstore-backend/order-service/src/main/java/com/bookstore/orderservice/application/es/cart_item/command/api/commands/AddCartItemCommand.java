package com.bookstore.orderservice.application.es.cart_item.command.api.commands;

import com.bookstore.orderservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class AddCartItemCommand extends BaseCommand<String> {
    private String cartId;
    private int quantity;
    private String productId;
    private String productName;
    private String images;
    private String productShortDescription;

    private double productPrice;

    public AddCartItemCommand(String id,
                              String cartId,
                              int quantity,
                              String productName,
                              String productShortDescription,
                              String images,
                              String productId,
                              double productPrice
    ) {
        super(id);
        this.cartId = cartId;
        this.quantity = quantity;
        this.productName = productName;
        this.productShortDescription = productShortDescription;
        this.images = images;
        this.productPrice = productPrice;
        this.productId = productId;
    }
}
