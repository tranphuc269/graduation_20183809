package com.bookstore.notificationservice.application.es.notification.query.model.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Data
@Builder
@Getter
@Setter
public class NotificationResponse {
    private String notificationId;
    private String sourceId;
    private String sourceType; // Nếu source type = ORDER chẳng hạn -> source id sẽ là order id;
    private int read; // 1-0
    private String content;
}
