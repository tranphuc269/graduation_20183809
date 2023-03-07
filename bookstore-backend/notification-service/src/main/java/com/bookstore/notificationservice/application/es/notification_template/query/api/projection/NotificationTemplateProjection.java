package com.bookstore.notificationservice.application.es.notification_template.query.api.projection;

import com.bookstore.notificationservice.application.es.notification_template.query.api.queries.GetAllTemplateQuery;
import com.bookstore.notificationservice.application.es.notification_template.query.api.queries.GetNotificationTemplateBySourceTypeQuery;
import com.bookstore.notificationservice.application.es.notification_template.query.model.NotificationTemplateQueryRepository;
import com.bookstore.notificationservice.application.es.notification_template.query.model.dto.NotificationTemplateResponse;
import com.bookstore.notificationservice.application.es.notification_template.query.model.entity.NotificationTemplateQueryEntity;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotificationTemplateProjection {

    @Autowired
    private NotificationTemplateQueryRepository repository;
    @QueryHandler
    public List<NotificationTemplateResponse> findAllTemplate(GetAllTemplateQuery query){
        List<NotificationTemplateQueryEntity> entities = repository.findAll();
        return entities
                .stream()
                .map(entity ->
                        NotificationTemplateResponse
                                .builder()
                                .notificationTemplateId(entity.getNotificationTemplateId())
                                .title(entity.getTitle())
                                .description(entity.getDescription())
                                .sourceType(entity.getSourceType())
                                .content(entity.getContent())
                                .build())
                .collect(Collectors.toList());
    }

    @QueryHandler
    public List<NotificationTemplateResponse> findNotificationTemplateBySourceType
            (GetNotificationTemplateBySourceTypeQuery query){
        List<NotificationTemplateQueryEntity> entities
                = repository.findAllBySourceType(query.getSourceType());
        return entities
                .stream()
                .map(entity ->
                        NotificationTemplateResponse
                                .builder()
                                .notificationTemplateId(entity.getNotificationTemplateId())
                                .title(entity.getTitle())
                                .description(entity.getDescription())
                                .sourceType(entity.getSourceType())
                                .content(entity.getContent())
                                .build())
                .collect(Collectors.toList());
    }

}
