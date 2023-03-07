package com.bookstore.notificationservice.application.es.notification_template.command.model.entity;

import com.bookstore.notificationservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Data
@Entity
@Table(name = "notification_templates")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationTemplateCommandEntity extends BaseModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "notification_template_d", updatable = false, nullable = false)
    private String notificationTemplateId;
    @Column(name = "title", updatable = false, nullable = false)
    private String title;
    @Column(name = "description", updatable = false, nullable = false)
    private String description;
    @Column(name = "source_type", updatable = false, nullable = false)
    private String sourceType;
    @Column(name = "content", updatable = false, nullable = false)
    private String content;
}
