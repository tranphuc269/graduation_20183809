package com.bookstore.notificationservice.infrastructure.kafka;

import com.bookstore.notificationservice.common.infrastructure.kafka.user_notification.KafkaUpdateNotificationFromUser;
import com.bookstore.notificationservice.common.utils.KafkaTopicUtils;
import com.bookstore.notificationservice.common.utils.notification.NotificationDestination;
import com.bookstore.notificationservice.application.es.notification.command.api.commands.CreateNotificationCommand;
import com.bookstore.notificationservice.application.es.notification_user.command.api.commands.CreateNotificationUserCommand;
import com.bookstore.notificationservice.domain.service.ISendNotificationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
public class OrderServiceKafkaConsumer {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private ISendNotificationService service;

    @KafkaListener(topics = KafkaTopicUtils.TOPIC_SEND_NOTIFICATION_FROM_ORDER)
    public void sendNotification(String kafkaMessage) {
        log.info("Kafka Message : " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {
            });
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }

        if (Objects.equals(map.get("destination").toString(), NotificationDestination.EMAIL.name())) {
            service.sendGmail();
        } else {
            service.sendNotificationToDevice();
            CreateNotificationCommand command =
                    new CreateNotificationCommand(UUID.randomUUID().toString(),
                            map.get("userId").toString(),
                            map.get("sourceId").toString(),
                            map.get("sourceType").toString(),
                            0, 0, "Cảm ơn bạn đã sử dụng dịch vụ. Kiện hàng " +
                            Arrays.asList(map.get("userId").toString().split("-")).get(0) +
                            " đã được xử lý.");
//            AggregateLifecycle.apply(command);
            commandGateway.send(command);
        }


    }


    @KafkaListener(topics = KafkaTopicUtils.TOPIC_UPDATE_NOTIFICATION_INFO_FROM_USER)
    public void createNotificationUser(String kafkaMessage) {
        log.info("Kafka Message from auth service: " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {
            });
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        KafkaUpdateNotificationFromUser updateNotificationFromUser
                = KafkaUpdateNotificationFromUser
                .builder()
                .userId(map.get("userId").toString())
                .email(map.get("email").toString())
                .firebaseToken(map.get("firebaseToken").toString())
                .userName(map.get("userName").toString())
                .build();
        CreateNotificationUserCommand command =
                new CreateNotificationUserCommand(UUID.randomUUID().toString(),
                        updateNotificationFromUser.getUserId(),
                        updateNotificationFromUser.getFirebaseToken(),
                        updateNotificationFromUser.getEmail(),
                        updateNotificationFromUser.getUserName());
        commandGateway.send(command);
    }
}