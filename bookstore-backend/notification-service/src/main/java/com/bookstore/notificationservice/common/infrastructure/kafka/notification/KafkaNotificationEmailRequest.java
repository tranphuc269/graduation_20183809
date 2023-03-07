package com.bookstore.notificationservice.common.infrastructure.kafka.notification;

import com.bookstore.notificationservice.common.utils.notification.NotificationDestination;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class KafkaNotificationEmailRequest extends KafkaNotificationRequest {
    private NotificationDestination destination;

    private String title;
    private String userId;
}
