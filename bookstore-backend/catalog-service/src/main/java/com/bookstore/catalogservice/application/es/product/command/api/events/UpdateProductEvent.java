package com.bookstore.catalogservice.application.es.product.command.api.events;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;



@Data
@Getter
@Builder
public class UpdateProductEvent {
    private String productId;
    private String name;

    private String shortContent;

    private String description;

    private double price;

    private int availableItemCount;

    private String images;

    private String authorId;

    private String categoryId;
}
