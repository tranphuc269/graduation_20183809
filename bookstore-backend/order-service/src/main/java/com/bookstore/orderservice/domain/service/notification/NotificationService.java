package com.bookstore.orderservice.domain.service.notification;

import com.bookstore.orderservice.common.infrastructure.kafka.notification.KafkaNotificationDeviceRequest;
import com.bookstore.orderservice.common.infrastructure.kafka.notification.KafkaNotificationEmailRequest;
import com.bookstore.orderservice.common.infrastructure.kafka.notification.KafkaNotificationRequest;

public interface NotificationService {
    public void send(KafkaNotificationRequest request);
}
