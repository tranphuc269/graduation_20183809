package com.bookstore.notificationservice.application.es.notification.command.model;

import com.bookstore.notificationservice.application.es.notification.command.model.entity.NotificationCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationCommandRepository
        extends JpaRepository<NotificationCommandEntity, String> {
}
