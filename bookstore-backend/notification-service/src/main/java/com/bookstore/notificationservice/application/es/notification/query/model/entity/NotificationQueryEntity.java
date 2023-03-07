package com.bookstore.notificationservice.application.es.notification.query.model.entity;

import com.bookstore.notificationservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "notifications")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationQueryEntity extends BaseModel {
    @Id
    @GeneratedValue(generator = "notification-uuid")
    @GenericGenerator(name = "notification-uuid", strategy = "uuid")
    @Column(name = "notification_id", updatable = false, nullable = false)
    private String notificationId;

    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @Column(name = "source_id", updatable = false, nullable = false)
    private String sourceId;
    @Column(name = "source_type", updatable = false, nullable = false)
    private String sourceType; // Nếu source type = ORDER chẳng hạn -> source id sẽ là order id;
    @Column(name = "has_read", updatable = false, nullable = false)
    private int hasRead;
    @Column(name = "trash", updatable = false, nullable = false)
    private int trash;
    @Column(name = "content", updatable = false, nullable = false)
    private String content;
}