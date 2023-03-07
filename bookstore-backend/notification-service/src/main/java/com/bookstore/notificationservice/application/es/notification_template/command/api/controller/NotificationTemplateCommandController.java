package com.bookstore.notificationservice.application.es.notification_template.command.api.controller;


import com.bookstore.notificationservice.common.application.response.dto.BaseResponse;
import com.bookstore.notificationservice.application.es.notification_template.command.api.commands.CreateNotificationTemplateCommand;
import com.bookstore.notificationservice.application.es.notification_template.command.model.dto.CreateNotificationTemplateRequest;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/notification-template-command")
@RestController
public class NotificationTemplateCommandController {

    @Autowired
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public BaseResponse<Void> createNotificationTemplate
            (@RequestBody CreateNotificationTemplateRequest request) {
        CreateNotificationTemplateCommand command =
                new CreateNotificationTemplateCommand(UUID.randomUUID().toString(),
                        request.getTitle(),
                        request.getDescription(),
                        request.getSourceType(),
                        request.getContent()
                );
        commandGateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PostMapping("/update")
    public BaseResponse<Void> updateNotificationTemplate
            (@RequestBody CreateNotificationTemplateRequest request) {
        CreateNotificationTemplateCommand command =
                new CreateNotificationTemplateCommand(UUID.randomUUID().toString(),
                        request.getTitle(),
                        request.getDescription(),
                        request.getSourceType(),
                        request.getContent()
                );
        commandGateway.send(command);
        return BaseResponse.ofSucceeded();
    }

}
