package com.bookstore.catalogservice.application.es.attribute.command.api.controller;


import com.bookstore.catalogservice.application.es.attribute.command.api.commands.CreateAttributeValueCommand;
import com.bookstore.catalogservice.application.es.attribute.command.write_data.request.CreateAttributeValueRequest;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
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
@RequestMapping("/attribute_value")
public class AttributeValueController {

    @Autowired
    private CommandGateway gateway;

    @PostMapping
    public BaseResponse<Void> createAttributeValue(@RequestBody CreateAttributeValueRequest request) {
        CreateAttributeValueCommand command = CreateAttributeValueCommand
                .builder()
                .attributeId(request.getAttributeId())
                .attributeValueId(UUID.randomUUID().toString())
                .value(request.getValue())
                .productId(request.getProductId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

}
