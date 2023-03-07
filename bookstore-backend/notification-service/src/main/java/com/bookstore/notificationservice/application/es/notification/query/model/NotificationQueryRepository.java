package com.bookstore.notificationservice.application.es.notification.query.model;

import com.bookstore.notificationservice.application.es.notification.query.model.entity.NotificationQueryEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface NotificationQueryRepository
        extends JpaRepository<NotificationQueryEntity, String> {
    List<NotificationQueryEntity> findAllByUserIdAndTrash(String userId,
                                                               int trash,
                                                               Pageable pageable);
}
