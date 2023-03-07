package com.bookstore.notificationservice.application.es.notification.query.api.controller;


import com.bookstore.notificationservice.application.es.notification.query.api.queries.GetNotificationQuery;
import com.bookstore.notificationservice.application.es.notification.query.model.model.NotificationResponse;
import com.bookstore.notificationservice.common.application.response.dto.BaseResponse;
import com.bookstore.notificationservice.common.utils.CommonUtilityMethods;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/notifications")
public class NotificationQueryController {
    @Autowired
    private QueryGateway queryGateway;

    @GetMapping("")
    public ResponseEntity<Object> getNotifications(@RequestParam("page") int page,
                                                   @RequestParam("per_page") int perPage) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = CommonUtilityMethods.getUserIdFromToken(authentication);
        GetNotificationQuery query = GetNotificationQuery
                .builder()
                .page(page)
                .size(perPage)
                .userId(userId)
                .build();
        List<NotificationResponse> notificationResponseList = queryGateway
                .query(query,
                        ResponseTypes.multipleInstancesOf(NotificationResponse.class)).join();
        return ResponseEntity.ok(
                BaseResponse.ofSucceeded(notificationResponseList)
        );

    }
}
