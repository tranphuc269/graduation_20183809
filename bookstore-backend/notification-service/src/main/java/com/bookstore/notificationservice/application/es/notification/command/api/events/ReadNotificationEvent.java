package com.bookstore.notificationservice.application.es.notification.command.api.events;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseEvent;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReadNotificationEvent extends BaseEvent<String> {
    private String notificationId;

    public ReadNotificationEvent(String id,
                                 String notificationId) {
        super(id);
        this.notificationId = notificationId;
    }
}
