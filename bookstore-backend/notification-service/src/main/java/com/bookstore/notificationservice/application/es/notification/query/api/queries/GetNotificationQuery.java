package com.bookstore.notificationservice.application.es.notification.query.api.queries;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetNotificationQuery {
    private String userId;
    private int page;
    private int size;
}
