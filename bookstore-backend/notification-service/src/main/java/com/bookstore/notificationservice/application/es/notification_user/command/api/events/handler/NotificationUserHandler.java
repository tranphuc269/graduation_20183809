package com.bookstore.notificationservice.application.es.notification_user.command.api.events.handler;

import com.bookstore.notificationservice.application.es.notification_user.command.api.events.CreateNotificationUserEvent;
import com.bookstore.notificationservice.application.es.notification_user.command.model.NotificationUserCommandRepository;
import com.bookstore.notificationservice.application.es.notification_user.command.model.entity.NotificationUserCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class NotificationUserHandler implements INotificationUserHandler{

    @Autowired
    private NotificationUserCommandRepository repository;

    @Override
    @EventHandler
    public void on(CreateNotificationUserEvent event) {
        NotificationUserCommandEntity entity = NotificationUserCommandEntity
                .builder()
                .userId(event.getUserId())
                .userName(event.getUserName())
                .firebaseToken(event.getFirebaseToken())
                .email(event.getEmail())
                .build();
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        entity.setStatus(1);
        repository.save(entity);
    }
}
