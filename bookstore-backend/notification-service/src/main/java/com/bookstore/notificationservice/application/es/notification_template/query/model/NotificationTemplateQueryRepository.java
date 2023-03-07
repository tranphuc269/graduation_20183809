package com.bookstore.notificationservice.application.es.notification_template.query.model;

import com.bookstore.notificationservice.application.es.notification_template.query.model.entity.NotificationTemplateQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationTemplateQueryRepository
        extends JpaRepository<NotificationTemplateQueryEntity, String> {
    List<NotificationTemplateQueryEntity> findAllBySourceType(String sourceType);
}
