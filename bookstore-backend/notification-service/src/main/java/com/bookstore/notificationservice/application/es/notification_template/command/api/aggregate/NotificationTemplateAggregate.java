package com.bookstore.notificationservice.application.es.notification_template.command.api.aggregate;


import com.bookstore.notificationservice.application.es.notification_template.command.api.commands.CreateNotificationTemplateCommand;
import com.bookstore.notificationservice.application.es.notification_template.command.api.commands.UpdateNotificationTemplateCommand;
import com.bookstore.notificationservice.application.es.notification_template.command.api.events.CreateNotificationTemplateEvent;
import com.bookstore.notificationservice.application.es.notification_template.command.api.events.UpdateNotificationTemplateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class NotificationTemplateAggregate {
    @AggregateIdentifier
    private String id;

    private String notificationTemplateId;
    private String title;
    private String description;
    private String sourceType;
    private String content;

    public NotificationTemplateAggregate() {
    }

    // create notification template
    @CommandHandler
    public NotificationTemplateAggregate(CreateNotificationTemplateCommand command) {
        CreateNotificationTemplateEvent event =
                new CreateNotificationTemplateEvent(UUID.randomUUID().toString(),
                        command.getTitle(),
                        command.getDescription(),
                        command.getSourceType(),
                        command.getContent());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateNotificationTemplateEvent event) {
        this.id = event.getId();
        this.notificationTemplateId = null;
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.sourceType = event.getSourceType();
        this.content = event.getDescription();
    }

    // update notification template
    @CommandHandler
    public NotificationTemplateAggregate(UpdateNotificationTemplateCommand command) {
        UpdateNotificationTemplateEvent event =
                new UpdateNotificationTemplateEvent(UUID.randomUUID().toString(),
                        command.getNotificationTemplateId(),
                        command.getTitle(),
                        command.getDescription(),
                        command.getSourceType(),
                        command.getContent());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(UpdateNotificationTemplateEvent event) {
        this.id = event.getId();
        this.notificationTemplateId = event.getNotificationTemplateId();
        this.title = event.getTitle();
        this.description = event.getDescription();
        this.sourceType = event.getSourceType();
        this.content = event.getDescription();
    }
}
