package com.bookstore.catalogservice.application.es.author.data.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class AuthorResponse {
    private String authorId;
    private String name;
    private List<String> images;
}
