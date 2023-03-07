package com.bookstore.catalogservice.application.es.attribute.command.api.events.attribute;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAttributeEvent {
    private String attributeId;
    private String name;
}
