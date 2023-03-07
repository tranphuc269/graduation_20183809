package com.bookstore.catalogservice.application.es.author.command.write_data.request;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class CreateAuthorRequest {
    private String authorName;
    private String images;
    private String description;
}
