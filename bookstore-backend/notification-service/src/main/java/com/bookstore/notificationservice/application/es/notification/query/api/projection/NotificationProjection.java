package com.bookstore.notificationservice.application.es.notification.query.api.projection;

import com.bookstore.notificationservice.application.es.notification.query.api.queries.GetNotificationQuery;
import com.bookstore.notificationservice.application.es.notification.query.model.NotificationQueryRepository;
import com.bookstore.notificationservice.application.es.notification.query.model.model.NotificationResponse;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class NotificationProjection {

    @Autowired
    private NotificationQueryRepository repository;

    @QueryHandler
    List<NotificationResponse> getNotification(GetNotificationQuery request) {
        if (request.getSize() == 0) {
            request.setSize(10);
        }
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        return repository
                .findAllByUserIdAndTrash(request.getUserId(),
                        0,
                        pageable)
                .stream().map(notify ->
                        NotificationResponse
                                .builder()
                                .notificationId(notify.getNotificationId())
                                .sourceId(notify.getSourceId())
                                .sourceType(notify.getSourceType())
                                .read(notify.getHasRead())
                                .content(notify.getContent())
                                .build())
                .collect(Collectors.toList());

    }
}
