package com.bookstore.catalogservice.application.es.product.command.api.events;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




@Getter
@Setter
@Builder
@Data
public class CreateProductEvent {
    private String name;

    private String shortContent;

    private String description;

    private double price;

    private int availableItemCount;

    private String images;

    private int quantitySold;

    private String authorId;

    private String categoryId;
}
