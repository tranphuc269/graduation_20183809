package com.bookstore.catalogservice.application.es.product.query.read_model.response;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AttributeProductResponse {
    private String productId;
    private String attributeId;
    private String name;
    private String value;
}
