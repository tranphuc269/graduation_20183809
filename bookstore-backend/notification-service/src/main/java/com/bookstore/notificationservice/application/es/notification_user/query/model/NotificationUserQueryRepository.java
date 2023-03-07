package com.bookstore.notificationservice.application.es.notification_user.query.model;

import com.bookstore.notificationservice.application.es.notification_user.query.model.entity.NotificationUserQueryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface NotificationUserQueryRepository
        extends JpaRepository<NotificationUserQueryEntity, String> {
    Optional<NotificationUserQueryEntity> findByUserId(String userId);
}
