package com.bookstore.catalogservice.application.es.author.command.api.controller;

import com.bookstore.catalogservice.application.es.author.command.api.commands.CreateAuthorCommand;
import com.bookstore.catalogservice.application.es.author.command.api.commands.DeleteAuthorCommand;
import com.bookstore.catalogservice.application.es.author.command.api.commands.EnableAuthorCommand;
import com.bookstore.catalogservice.application.es.author.command.write_data.request.CreateAuthorRequest;
import com.bookstore.catalogservice.application.es.author.command.write_data.request.DeleteAuthorRequest;
import com.bookstore.catalogservice.application.es.author.command.write_data.request.EnableAuthorRequest;
import com.bookstore.catalogservice.application.es.author.command.write_data.request.UpdateAuthorRequest;
import com.bookstore.catalogservice.application.es.author.command.api.commands.UpdateAuthorCommand;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@NoArgsConstructor
@RequestMapping("/author")
public class AuthorCommandController {

    @Autowired
    private CommandGateway gateway;


    @PostMapping
    public BaseResponse<Void> createAuthor(@RequestBody CreateAuthorRequest request){
        CreateAuthorCommand command = CreateAuthorCommand
                .builder()
                .authorName(request.getAuthorName())
                .description(request.getDescription())
                .identity(UUID.randomUUID().toString())
                .images(request.getImages())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PutMapping
    public BaseResponse<Void> updateAuthor(@RequestBody UpdateAuthorRequest request){
        UpdateAuthorCommand command = UpdateAuthorCommand
                .builder()
                .authorName(request.getAuthorName())
                .description(request.getDescription())
                .authorId(request.getAuthorId())
                .images(request.getImages())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }


    @DeleteMapping("/{authorId}")
    public BaseResponse<Void> deleteAuthor(@PathVariable String authorId){
        DeleteAuthorRequest request = DeleteAuthorRequest
                .builder()
                .authorId(authorId)
                .build();
        DeleteAuthorCommand command = DeleteAuthorCommand
                .builder()
                .authorId(request.getAuthorId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PutMapping("/enable/{authorId}")
    public BaseResponse<Void> enableAuthor(@PathVariable String authorId){
        EnableAuthorRequest request = EnableAuthorRequest
                .builder()
                .authorId(authorId)
                .build();
        EnableAuthorCommand command = EnableAuthorCommand
                .builder()
                .authorId(authorId)
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }
}
