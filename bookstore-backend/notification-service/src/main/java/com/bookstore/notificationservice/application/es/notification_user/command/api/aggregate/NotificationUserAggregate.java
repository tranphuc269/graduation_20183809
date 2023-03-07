package com.bookstore.notificationservice.application.es.notification_user.command.api.aggregate;


import com.bookstore.notificationservice.application.es.notification_user.command.api.commands.CreateNotificationUserCommand;
import com.bookstore.notificationservice.application.es.notification_user.command.api.events.CreateNotificationUserEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Column;
import java.util.UUID;

@Aggregate
public class NotificationUserAggregate {

    @AggregateIdentifier
    private String id;
    private String userId;
    private String firebaseToken;
    private String email;
    private String userName;

    public NotificationUserAggregate(){

    }


    // when create user
    @CommandHandler
    public NotificationUserAggregate(CreateNotificationUserCommand command){
        CreateNotificationUserEvent event = new CreateNotificationUserEvent(
                UUID.randomUUID().toString(),
                command.getUserId(),
                command.getFirebaseToken(),
                command.getEmail(),
                command.getUserName()
        );
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateNotificationUserEvent event){
        this.id = event.getId();
        this.userId = event.getUserId();
        this.email = event.getEmail();
        this.firebaseToken = event.getFirebaseToken();
        this.userName = event.getUserName();
    }

}
