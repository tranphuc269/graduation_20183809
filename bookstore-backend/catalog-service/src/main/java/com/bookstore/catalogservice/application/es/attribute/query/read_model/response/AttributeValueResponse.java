package com.bookstore.catalogservice.application.es.attribute.query.read_model.response;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class AttributeValueResponse {
    private String attributeValueId;

    private String attributeId;
    private String value;
    private String productId;
}
