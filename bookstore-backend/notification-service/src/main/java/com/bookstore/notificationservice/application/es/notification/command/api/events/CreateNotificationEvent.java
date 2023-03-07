package com.bookstore.notificationservice.application.es.notification.command.api.events;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateNotificationEvent extends BaseEvent<String> {
    private String userId;
    private String sourceId;
    private String sourceType;
    private int read;
    private int trash;
    private String content;

    public CreateNotificationEvent(String id,
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
