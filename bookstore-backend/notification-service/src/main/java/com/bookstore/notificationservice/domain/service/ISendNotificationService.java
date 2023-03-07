package com.bookstore.notificationservice.domain.service;

public interface ISendNotificationService {
    void sendGmail();
    void sendNotificationToDevice();
}
