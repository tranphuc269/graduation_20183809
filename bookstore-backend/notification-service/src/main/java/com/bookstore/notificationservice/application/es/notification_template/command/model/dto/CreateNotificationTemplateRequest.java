package com.bookstore.notificationservice.application.es.notification_template.command.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateNotificationTemplateRequest {
    private String title;
    private String description;
    private String sourceType;
    private String content;
}
