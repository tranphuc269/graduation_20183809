package com.bookstore.orderservice.common.infrastructure.kafka.notification;


import com.bookstore.orderservice.common.utils.notification.NotificationDestination;
import com.bookstore.orderservice.common.utils.notification.NotificationSourceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class KafkaNotificationDeviceRequest extends KafkaNotificationRequest {
    private NotificationDestination destination;
    private String title;
    private String userId;
    private String sourceId; // if order -> orderId
    private NotificationSourceType sourceType; // order, product, campaign
}
