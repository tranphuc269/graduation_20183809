package com.bookstore.notificationservice.application.es.notification_template.command.api.events;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateNotificationTemplateEvent extends BaseEvent<String> {
    private String notificationTemplateId;
    private String title;
    private String description;
    private String sourceType;
    private String content;

    public UpdateNotificationTemplateEvent(String id,
                                           String notificationTemplateId,
                                           String title,
                                           String description,
                                           String sourceType,
                                           String content) {
        super(id);
        this.notificationTemplateId = notificationTemplateId;
        this.title = title;
        this.description = description;
        this.sourceType = sourceType;
        this.content = content;
    }
}
