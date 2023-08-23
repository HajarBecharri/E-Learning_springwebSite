package com.example.notification.Repository;

import com.example.notification.Model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRepo extends JpaRepository<Notification,Long> {
    List<Notification> findByRecipientIdAndLuFalseOrderByTimestampDesc(Long recipientId);
    List<Notification> findByRecipientIdOrderByTimestampDesc(Long recipientId);
}
