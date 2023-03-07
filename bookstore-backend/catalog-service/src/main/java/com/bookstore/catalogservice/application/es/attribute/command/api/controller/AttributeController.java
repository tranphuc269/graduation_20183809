package com.bookstore.catalogservice.application.es.attribute.command.api.controller;


import com.bookstore.catalogservice.application.es.attribute.command.api.commands.CreateAttributeCommand;
import com.bookstore.catalogservice.application.es.attribute.command.write_data.request.CreateAttributeRequest;
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
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private CommandGateway gateway;

    @PostMapping
    public BaseResponse<String> createAttribute(@RequestBody CreateAttributeRequest request) {
        CreateAttributeCommand command = CreateAttributeCommand
                .builder()
                .attributeId(UUID.randomUUID().toString())
                .name(request.getName())
                .build();
        String result = gateway.sendAndWait(command);
        return BaseResponse.ofSucceeded(result);
    }

}
