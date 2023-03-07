package com.bookstore.authservice.infrastructure;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class KafkaUpdateNotificationFromUser {
    private String email;
    private String firebaseToken;
    private String userId;
    private String userName;
}