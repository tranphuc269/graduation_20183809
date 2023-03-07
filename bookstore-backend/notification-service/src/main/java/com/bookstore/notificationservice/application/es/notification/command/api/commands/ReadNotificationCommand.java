package com.bookstore.notificationservice.application.es.notification.command.api.commands;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ReadNotificationCommand extends BaseCommand<String> {
    private String notificationId;

    public ReadNotificationCommand(String id,
                                   String notificationId) {
        super(id);
        this.notificationId = notificationId;
    }
}
