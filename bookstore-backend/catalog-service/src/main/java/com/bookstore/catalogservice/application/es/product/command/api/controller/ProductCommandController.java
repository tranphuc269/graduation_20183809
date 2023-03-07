package com.bookstore.catalogservice.application.es.product.command.api.controller;


import com.bookstore.catalogservice.application.es.product.command.api.commands.CreateProductCommand;
import com.bookstore.catalogservice.application.es.product.command.api.commands.DeleteProductCommand;
import com.bookstore.catalogservice.application.es.product.command.api.commands.EnableProductCommand;
import com.bookstore.catalogservice.application.es.product.command.api.commands.UpdateProductCommand;
import com.bookstore.catalogservice.application.es.product.command.write_model.request.CreateProductRequest;
import com.bookstore.catalogservice.application.es.product.command.write_model.request.EnableProductRequest;
import com.bookstore.catalogservice.application.es.product.command.write_model.request.UpdateProductRequest;
import com.bookstore.catalogservice.application.es.product.command.write_model.request.DeleteProductRequest;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/product")
public class ProductCommandController {

    @Autowired
    private CommandGateway gateway;

    @PostMapping
    public BaseResponse<Void> createProduct(@RequestBody CreateProductRequest request) {
        CreateProductCommand command = CreateProductCommand
                .builder()
                .name(request.getName())
                .shortContent(request.getShortContent())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableItemCount(request.getAvailableItemCount())
                .images(request.getImages())
                .categoryId(request.getCategoryId())
                .authorId(request.getAuthorId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PutMapping
    public BaseResponse<Void> updateProduct(@RequestBody UpdateProductRequest request) {
        UpdateProductCommand command = UpdateProductCommand
                .builder()
                .productId(request.getProductId())
                .name(request.getName())
                .shortContent(request.getShortContent())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableItemCount(request.getAvailableItemCount())
                .images(request.getImages())
                .categoryId(request.getCategoryId())
                .authorId(request.getAuthorId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @DeleteMapping("/{productId}")
    public BaseResponse<Void> updateProduct(@PathVariable String productId) {
        DeleteProductRequest request = DeleteProductRequest
                .builder()
                .productId(productId)
                .build();
        DeleteProductCommand command = DeleteProductCommand
                .builder()
                .productId(request.getProductId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PutMapping("/enable/{productId}")
    public BaseResponse<Void> enableProduct(@PathVariable String productId) {
        EnableProductRequest request = EnableProductRequest
                .builder()
                .productId(productId)
                .build();
        EnableProductCommand command = EnableProductCommand
                .builder()
                .productId(request.getProductId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }
}
