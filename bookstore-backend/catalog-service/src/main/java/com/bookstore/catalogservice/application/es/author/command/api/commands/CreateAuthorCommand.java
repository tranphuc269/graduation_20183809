package com.bookstore.catalogservice.application.es.author.command.api.commands;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateAuthorCommand {
    private String identity;
    private String authorName;
    private String images;
    private String description;
}
