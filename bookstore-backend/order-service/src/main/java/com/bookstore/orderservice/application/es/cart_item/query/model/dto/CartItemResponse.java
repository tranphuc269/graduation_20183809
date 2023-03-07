package com.bookstore.orderservice.application.es.cart_item.query.model.dto;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.List;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemResponse {
    private String cartItemId;

    private String productId;
    private double productPrice;

    private String productName;

    private String productShortContent;

    private List<String> images;

    private int quantity;
}
