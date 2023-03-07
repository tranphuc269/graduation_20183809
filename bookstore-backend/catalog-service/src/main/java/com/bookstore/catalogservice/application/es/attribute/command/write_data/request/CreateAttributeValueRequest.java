package com.bookstore.catalogservice.application.es.attribute.command.write_data.request;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class CreateAttributeValueRequest {
    private String attributeId;

    private String value;

    private String productId;
}
