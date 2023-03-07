package com.bookstore.common.infrastructure.kafka.product_order;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class KafkaSendProductCreateCartItem {
    private String userId;
    private int quantity;
    private String productId;
    private String productName;
    private String images;
    private String productShortDescription;
    private double productPrice;
}
