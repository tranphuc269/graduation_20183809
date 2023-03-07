package com.bookstore.catalogservice.application.es.product.command.write_model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;




@Data
@Getter
@Builder
public class UpdateProductRequest {
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
