package com.example.notification.Service;

import com.example.notification.Model.Notification;
import org.springframework.stereotype.Service;

import java.util.List;


public interface INotificationService {

    Notification createNotification(Notification notification);
    List<Notification> getUnreadNotifications(Long recipientId);
    List<Notification> getAllNotifications(Long recipientId);

    Notification markNotificationAsRead(Long notificationId);
}
