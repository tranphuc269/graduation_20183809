package com.bookstore.notificationservice.application.es.notification.command.api.commands;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateNotificationCommand extends BaseCommand<String> {

    private String userId;
    private String sourceId;
    private String sourceType;
    private int read;
    private int trash;
    private String content;

    public CreateNotificationCommand(String id,
                                     String userId,
                                     String sourceId,
                                     String sourceType,
                                     int read,
                                     int trash,
                                     String content) {
        super(id);
        this.userId = userId;
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.read = read;
        this.trash = trash;
        this.content = content;
    }
}
