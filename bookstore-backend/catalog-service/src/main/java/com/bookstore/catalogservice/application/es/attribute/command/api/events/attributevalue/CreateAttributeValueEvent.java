package com.bookstore.catalogservice.application.es.attribute.command.api.events.attributevalue;


import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAttributeValueEvent {
    private String attributeValueId;
    private String attributeId;

    private String value;

    private String productId;
}
