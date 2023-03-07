package com.bookstore.notificationservice.application.es.notification_user.command.api.events.handler;

import com.bookstore.notificationservice.application.es.notification_user.command.api.events.CreateNotificationUserEvent;

public interface INotificationUserHandler {
    public void on(CreateNotificationUserEvent event);
}
