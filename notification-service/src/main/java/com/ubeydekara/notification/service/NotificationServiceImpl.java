package com.ubeydekara.notification.service;

import com.ubeydekara.notification.model.Device;
import com.ubeydekara.notification.payload.NotificationPayload;
import com.ubeydekara.notification.repository.DeviceRepository;
import com.ubeydekara.notification.response.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final DeviceRepository deviceRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final static String expoPushUrl = "https://exp.host/--/api/v2/push/send";

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public NotificationResponse sendNotification(NotificationPayload notificationPayload) {
        // prepare the device list
        List<String> deviceTokens = deviceRepository.findAll().stream().map(Device::getNotificationToken).toList();
        notificationPayload.setTo(deviceTokens);

        if (deviceTokens.isEmpty())
            return null;

        // push to expo servers
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<NotificationPayload> entity = new HttpEntity<>(notificationPayload, headers);
        return restTemplate.exchange(expoPushUrl, HttpMethod.POST, entity, NotificationResponse.class).getBody();
    }
}
