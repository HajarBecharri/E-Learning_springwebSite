package com.example.notification.Controller;

import com.example.notification.Model.Notification;
import com.example.notification.Service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private final NotificationService notificationService;



    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        Notification createdNotification = notificationService.createNotification(notification);
        return ResponseEntity.ok(createdNotification);
    }

    @GetMapping("/{recipientId}/unread")
    public ResponseEntity<List<Notification>> getUnreadNotifications(@PathVariable Long recipientId) {
        List<Notification> unreadNotifications = notificationService.getUnreadNotifications(recipientId);
        return ResponseEntity.ok(unreadNotifications);
    }

    @GetMapping("/{recipientId}/all")
    public ResponseEntity<List<Notification>> getAlldNotifications(@PathVariable Long recipientId) {
        List<Notification> unreadNotifications = notificationService.getAllNotifications(recipientId);
        return ResponseEntity.ok(unreadNotifications);
    }

    @GetMapping("/mark/{notificationId}")
    public ResponseEntity<Notification> markNotificationAsRead(@PathVariable Long notificationId) {
        Notification ReadNotification = notificationService.markNotificationAsRead(notificationId);
        return ResponseEntity.ok(ReadNotification);
    }


}
