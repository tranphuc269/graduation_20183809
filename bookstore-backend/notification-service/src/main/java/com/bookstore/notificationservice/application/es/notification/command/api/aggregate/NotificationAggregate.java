package com.bookstore.notificationservice.application.es.notification.command.api.aggregate;


import com.bookstore.notificationservice.application.es.notification.command.api.commands.CreateNotificationCommand;
import com.bookstore.notificationservice.application.es.notification.command.api.commands.ReadNotificationCommand;
import com.bookstore.notificationservice.application.es.notification.command.api.commands.RemoveNotificationCommand;
import com.bookstore.notificationservice.application.es.notification.command.api.events.CreateNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.api.events.ReadNotificationEvent;
import com.bookstore.notificationservice.application.es.notification.command.api.events.RemoveNotificationEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.UUID;

@Aggregate
public class NotificationAggregate {
    @AggregateIdentifier
    private String id;
    private String notificationId;
    private String userId;
    private String sourceId;
    private String sourceType;
    private int read;
    private int trash;
    private String content;

    public NotificationAggregate() {
    }

    @CommandHandler
    public NotificationAggregate(CreateNotificationCommand command) {
        System.out.println("Ping");
        CreateNotificationEvent event =
                new CreateNotificationEvent(UUID.randomUUID().toString(),
                        command.getUserId(),
                        command.getSourceId(),
                        command.getSourceType(),
                        0, 0,
                        command.getContent());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateNotificationEvent event) {
        this.id = event.getId();
        this.content = event.getContent();
        this.read = 0;
        this.trash = 0;
        this.userId = event.getUserId();
        this.sourceId = event.getSourceId();
        this.sourceType = event.getSourceType();
        this.notificationId = null;
    }


    @CommandHandler
    public NotificationAggregate(ReadNotificationCommand command) {
        ReadNotificationEvent event =
                new ReadNotificationEvent(UUID.randomUUID().toString(),
                        command.getNotificationId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReadNotificationEvent event) {
        this.id = event.getId();
        this.notificationId = event.getNotificationId();
    }

    @CommandHandler
    public NotificationAggregate(RemoveNotificationCommand command) {
        RemoveNotificationEvent event =
                new RemoveNotificationEvent(UUID.randomUUID().toString(),
                        command.getNotificationId(),
                        command.getUserId(),
                        command.getSourceId(),
                        command.getSourceType(),
                        command.getContent());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(RemoveNotificationEvent event) {
        this.id = event.getId();
        this.content = event.getContent();
        this.read = 0;
        this.trash = 0;
        this.userId = event.getUserId();
        this.sourceId = event.getSourceId();
        this.sourceType = event.getSourceType();
        this.notificationId = event.getNotificationId();
    }


}
