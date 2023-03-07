package com.bookstore.notificationservice.application.es.notification.command.api.commands;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RemoveNotificationCommand extends BaseCommand<String> {
    private String notificationId;
    private String userId;
    private String sourceId;
    private String sourceType;
    private int read;
    private int trash;
    private String content;

    public RemoveNotificationCommand(String id,
                                   String notificationId,
                                   String userId,
                                   String sourceId,
                                   String sourceType,
                                   String content) {
        super(id);
        this.notificationId = notificationId;
        this.userId = userId;
        this.sourceId = sourceId;
        this.sourceType = sourceType;
        this.read = 1;
        this.trash = 1;
        this.content = content;
    }
}
