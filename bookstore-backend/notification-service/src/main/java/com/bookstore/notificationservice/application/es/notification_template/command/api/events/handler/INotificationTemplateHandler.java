package com.bookstore.notificationservice.application.es.notification_template.command.api.events.handler;

import com.bookstore.notificationservice.application.es.notification_template.command.api.events.CreateNotificationTemplateEvent;
import com.bookstore.notificationservice.application.es.notification_template.command.api.events.UpdateNotificationTemplateEvent;

public interface INotificationTemplateHandler {
    public void on(CreateNotificationTemplateEvent event);
    public void on(UpdateNotificationTemplateEvent event);
}
