package com.bookstore.catalogservice.application.es.author.command.api.events;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeleteAuthorEvent {
    private String authorId;
}
