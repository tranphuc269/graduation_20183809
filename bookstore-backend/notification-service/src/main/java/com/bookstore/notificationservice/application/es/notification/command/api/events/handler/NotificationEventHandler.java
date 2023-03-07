package com.bookstore.notificationservice.application.es.notification.command.api.events.handler;

import com.bookstore.notificationservice.application.es.notification.command.api.events.CreateNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.api.events.ReadNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.api.events.RemoveNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.model.NotificationCommandRepository;
import com.bookstore.notificationservice.application.es.notification.command.model.entity.NotificationCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


@Component
public class NotificationEventHandler implements INotificationEventHandler {

    @Autowired
    private NotificationCommandRepository repository;

    @Override
    @EventHandler
    public void on(CreateNotificationEvent event) {
        System.out.println("Pong");
        NotificationCommandEntity entity = NotificationCommandEntity
                .builder()
                .userId(event.getUserId())
                .sourceId(event.getSourceId())
                .sourceType(event.getSourceType())
                .hasRead(0)
                .trash(0)
                .content(event.getContent())
                .build();
        entity.setStatus(1);
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        repository.save(entity);
    }

    @Override
    @EventHandler
    public void on(ReadNotificationEvent event) {
        Optional<NotificationCommandEntity> entity = repository.findById(event.getNotificationId());
        if(entity.isPresent()){
            entity.get().setHasRead(1);
            repository.save(entity.get());
        }
    }

    @Override
    @EventHandler
    public void on(RemoveNotificationEvent event) {
        Optional<NotificationCommandEntity> entity = repository.findById(event.getNotificationId());
        if(entity.isPresent()){
            entity.get().setTrash(1);
            repository.save(entity.get());
        }
    }
}