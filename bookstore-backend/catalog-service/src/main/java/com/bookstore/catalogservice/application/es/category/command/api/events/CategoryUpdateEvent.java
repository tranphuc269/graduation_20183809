package com.bookstore.catalogservice.application.es.category.command.api.events;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CategoryUpdateEvent {
    private String categoryId;
    private String categoryName;
    private String description;
    private String image;
}
