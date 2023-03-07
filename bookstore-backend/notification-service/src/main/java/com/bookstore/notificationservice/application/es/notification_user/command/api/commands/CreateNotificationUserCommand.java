package com.bookstore.notificationservice.application.es.notification_user.command.api.commands;

import com.bookstore.notificationservice.common.infrastructure.axon.BaseCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateNotificationUserCommand extends BaseCommand<String> {

    private String userId;
    private String firebaseToken;
    private String email;
    private String userName;
    public CreateNotificationUserCommand(String id,
                                         String userId,
                                         String firebaseToken,
                                         String email,
                                         String userName) {
        super(id);
        this.userId = userId;
        this.userName = userName;
        this.firebaseToken = firebaseToken;
        this.email = email;
    }
}
