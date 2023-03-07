package com.bookstore.notificationservice.application.es.notification_user.query.model.entity;

import com.bookstore.notificationservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "notification_users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationUserQueryEntity extends BaseModel {
    @Id
    @GeneratedValue(generator = "notification-users-uuid")
    @GenericGenerator(name = "notification-users-uuid", strategy = "uuid")
    @Column(name = "notification_user_id", updatable = false, nullable = false)
    private String notificationUserId;

    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @Column(name = "firebase_token", updatable = false, nullable = false)
    private String firebaseToken;
    @Column(name = "email", updatable = false, nullable = false)
    private String email;
    @Column(name = "user_name", updatable = false, nullable = false)
    private String userName;
}
