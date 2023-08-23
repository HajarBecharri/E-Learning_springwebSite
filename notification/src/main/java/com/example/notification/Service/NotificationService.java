package com.example.notification.Service;

import com.example.notification.Model.Notification;
import com.example.notification.Repository.NotificationRepo;
import jakarta.ws.rs.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    private NotificationRepo notificationRepository;
    @Override
    public Notification createNotification(Notification notification) {
        notification.setTimestamp(LocalDateTime.now());
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> getUnreadNotifications(Long recipientId) {
        return notificationRepository.findByRecipientIdAndLuFalseOrderByTimestampDesc(recipientId);
    }

    @Override
    public List<Notification> getAllNotifications(Long recipientId) {
        return notificationRepository.findByRecipientIdOrderByTimestampDesc(recipientId);
    }

    @Override
    public Notification markNotificationAsRead(Long notificationId) {
        Notification notification = notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotFoundException("Notification not found"));

        // Mark the notification as read
        notification.setLu(true);
        notificationRepository.save(notification);

        return notification;
    }
}
