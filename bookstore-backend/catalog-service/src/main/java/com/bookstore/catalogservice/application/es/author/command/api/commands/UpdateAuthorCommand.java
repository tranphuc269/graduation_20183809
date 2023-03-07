package com.bookstore.catalogservice.application.es.author.command.api.commands;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
@AllArgsConstructor
public class UpdateAuthorCommand {
    private String authorId;
    private String authorName;
    private String description;
    private String images;

    private int status;
}
