package com.bookstore.catalogservice.application.es.author.command.api.events;

import lombok.*;
import org.checkerframework.checker.units.qual.A;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthorEvent {
    private String authorId;
    private String authorName;
    private String description;
    private String images;

    private int status;
}
