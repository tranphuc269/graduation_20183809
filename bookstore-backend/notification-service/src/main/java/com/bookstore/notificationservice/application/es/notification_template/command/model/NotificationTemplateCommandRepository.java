package com.bookstore.notificationservice.application.es.notification_template.command.model;

import com.bookstore.notificationservice.application.es.notification_template.command.model.entity.NotificationTemplateCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationTemplateCommandRepository
        extends JpaRepository<NotificationTemplateCommandEntity, String> {
}
