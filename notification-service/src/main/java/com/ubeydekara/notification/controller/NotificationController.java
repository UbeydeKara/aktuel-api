package com.ubeydekara.notification.controller;

import com.ubeydekara.notification.model.Device;
import com.ubeydekara.notification.payload.NotificationPayload;
import com.ubeydekara.notification.response.NotificationResponse;
import com.ubeydekara.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
@ControllerAdvice
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/register")
    public Device registerDevice(@RequestBody Device device) {
        return notificationService.addDevice(device);
    }

    @PostMapping
    public NotificationResponse pushNotification(@RequestBody NotificationPayload payload) {
        return notificationService.sendNotification(payload);
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
