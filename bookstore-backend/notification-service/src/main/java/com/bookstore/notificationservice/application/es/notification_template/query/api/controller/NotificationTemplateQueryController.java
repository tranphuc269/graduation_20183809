package com.bookstore.notificationservice.application.es.notification_template.query.api.controller;

import com.bookstore.notificationservice.common.application.response.dto.BaseResponse;
import com.bookstore.notificationservice.application.es.notification_template.query.api.queries.GetAllTemplateQuery;
import com.bookstore.notificationservice.application.es.notification_template.query.api.queries.GetNotificationTemplateBySourceTypeQuery;
import com.bookstore.notificationservice.application.es.notification_template.query.model.dto.NotificationTemplateResponse;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/notification-template-query")
@RestController
@NoArgsConstructor
public class NotificationTemplateQueryController {

    @Autowired
    private QueryGateway queryGateway;

    @PostMapping("/")
    public BaseResponse<Object> findAllTemplate() {
        GetAllTemplateQuery query = new GetAllTemplateQuery();
        return BaseResponse.ofSucceeded(
                queryGateway.query(
                                query,
                                ResponseTypes.multipleInstancesOf(NotificationTemplateResponse.class))
                        .join()
        );
    }

    @PostMapping("/{sourceType}")
    public BaseResponse<Object> findTemplateBySourceType(@PathVariable String sourceType) {
        GetNotificationTemplateBySourceTypeQuery query = GetNotificationTemplateBySourceTypeQuery
                .builder()
                .sourceType(sourceType)
                .build();
        return BaseResponse.ofSucceeded(
                queryGateway.query(
                                query,
                                ResponseTypes.multipleInstancesOf(NotificationTemplateResponse.class))
                        .join()
        );
    }

}
