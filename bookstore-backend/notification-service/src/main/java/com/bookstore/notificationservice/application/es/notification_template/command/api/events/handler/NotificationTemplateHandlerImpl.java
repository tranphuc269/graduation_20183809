package com.bookstore.notificationservice.application.es.notification_template.command.api.events.handler;

import com.bookstore.notificationservice.application.es.notification_template.command.api.events.CreateNotificationTemplateEvent;
import com.bookstore.notificationservice.application.es.notification_template.command.api.events.UpdateNotificationTemplateEvent;
import com.bookstore.notificationservice.application.es.notification_template.command.model.NotificationTemplateCommandRepository;
import com.bookstore.notificationservice.application.es.notification_template.command.model.entity.NotificationTemplateCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;


@Component
public class NotificationTemplateHandlerImpl implements INotificationTemplateHandler {

    @Autowired
    private NotificationTemplateCommandRepository repository;

    @Override
    @EventHandler
    public void on(CreateNotificationTemplateEvent event) {
        NotificationTemplateCommandEntity entity = NotificationTemplateCommandEntity
                .builder()
                .title(event.getTitle())
                .description(event.getDescription())
                .sourceType(event.getSourceType())
                .content(event.getContent())
                .build();
        entity.setStatus(1);
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        repository.save(entity);
    }

    @Override
    @EventHandler
    public void on(UpdateNotificationTemplateEvent event) {
        Optional<NotificationTemplateCommandEntity> notificationTemplateCommand
                = repository.findById(event.getNotificationTemplateId());
        if (notificationTemplateCommand.isPresent()) {
            notificationTemplateCommand.get().setTitle(event.getTitle());
            notificationTemplateCommand.get().setContent(event.getContent());
            notificationTemplateCommand.get().setDescription(event.getDescription());
            notificationTemplateCommand.get().setSourceType(event.getSourceType());
            repository.save(notificationTemplateCommand.get());
        }
    }
}
