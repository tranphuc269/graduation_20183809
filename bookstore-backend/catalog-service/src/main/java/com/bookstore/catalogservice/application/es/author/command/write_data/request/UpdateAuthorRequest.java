package com.bookstore.catalogservice.application.es.author.command.write_data.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class UpdateAuthorRequest {
    String authorId;
    private String authorName;
    private String images;
    private String description;
}
