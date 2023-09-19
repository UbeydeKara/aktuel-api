package com.ubeydekara.notification.service;

import com.ubeydekara.notification.model.Device;
import com.ubeydekara.notification.payload.NotificationPayload;
import com.ubeydekara.notification.response.NotificationResponse;

public interface NotificationService {
    Device addDevice(Device device);
    NotificationResponse sendNotification(NotificationPayload notificationPayload);
}
