package com.bookstore.catalogservice.application.es.category.command.api.controller;


import com.bookstore.catalogservice.application.es.category.data.dto.CreateCategoryRequest;
import com.bookstore.catalogservice.application.es.category.command.api.commands.CreateCategoryCommand;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@NoArgsConstructor
@RequestMapping("/category")
public class CategoryCommandController {

    @Autowired
    private CommandGateway commandGateway;


    @PostMapping
    public String createCategory(@RequestBody CreateCategoryRequest request){
        CreateCategoryCommand command = CreateCategoryCommand
                .builder()
                .categoryId(UUID.randomUUID().toString())
                .categoryName(request.getCategoryName())
                .description(request.getDescription())
                .image(request.getImage())
                .build();
        String result = commandGateway.sendAndWait(command);
        return result;
    }

}
