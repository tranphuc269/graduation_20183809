package com.bookstore.notificationservice.application.es.notification_template.query.api.queries;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GetNotificationTemplateBySourceTypeQuery {
    private String sourceType;
}
