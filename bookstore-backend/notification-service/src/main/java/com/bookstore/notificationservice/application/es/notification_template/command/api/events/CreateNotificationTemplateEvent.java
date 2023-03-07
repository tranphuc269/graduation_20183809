package com.bookstore.notificationservice.application.es.notification_template.command.api.events;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CreateNotificationTemplateEvent extends BaseEvent<String> {

    private String title;
    private String description;
    private String sourceType;

    private String content;

    public CreateNotificationTemplateEvent(String id,
                                           String title,
                                           String description,
                                           String sourceType,
                                           String content) {
        super(id);
        this.title = title;
        this.description = description;
        this.sourceType = sourceType;
        this.content = content;
    }
}
