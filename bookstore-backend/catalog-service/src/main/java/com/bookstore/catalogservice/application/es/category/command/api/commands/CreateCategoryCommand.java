package com.bookstore.catalogservice.application.es.category.command.api.commands;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
@Setter
@Getter
public class CreateCategoryCommand {
    @TargetAggregateIdentifier
    private String categoryId;
    private String categoryName;
    private String description;
    private String image;
}
