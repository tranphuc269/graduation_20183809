package com.bookstore.notificationservice.application.es.notification.command.api.controller;

import com.bookstore.notificationservice.application.es.notification.command.api.commands.ReadNotificationCommand;
import com.bookstore.notificationservice.common.application.response.dto.BaseResponse;
import com.bookstore.notificationservice.domain.service.ISendNotificationService;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/notification")
@RestController
public class NotificationController {


    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private ISendNotificationService notificationService;

    @PostMapping("/email")
    public void sendEmail() {
        notificationService.sendGmail();
    }

    @PatchMapping("/read/{notificationId}")
    public ResponseEntity<BaseResponse<Void>> readNotification(@PathVariable String notificationId) {
        ReadNotificationCommand command = new ReadNotificationCommand(UUID.randomUUID().toString(), notificationId);
        commandGateway.send(command);
        return ResponseEntity.ok(BaseResponse.ofSucceeded());
    }
}