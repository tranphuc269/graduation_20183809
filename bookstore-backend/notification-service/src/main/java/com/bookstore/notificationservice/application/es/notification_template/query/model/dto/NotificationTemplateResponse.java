package com.bookstore.notificationservice.application.es.notification_template.query.model.dto;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
@Builder
@Getter
@Setter
public class NotificationTemplateResponse {
    private String notificationTemplateId;
    private String title;
    private String description;
    private String sourceType;
    private String content;
    private String sourceId; // cái này có thể là productId, orderId, categoryId phụ thuộc vào sourceType
}
