package com.bookstore.notificationservice.application.es.notification.command.api.events.handler;

import com.bookstore.notificationservice.application.es.notification.command.api.events.CreateNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.api.events.ReadNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.api.events.RemoveNotificationEvent;

public interface INotificationEventHandler {

    public void on(CreateNotificationEvent event);

    public void on(ReadNotificationEvent event);

    public void on(RemoveNotificationEvent event);

}
