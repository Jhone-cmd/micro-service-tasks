package com.jhonecmd.service_tasks.communication;

import com.jhonecmd.service_tasks.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "service-notification")
public interface NotificationClient {
    @PostMapping("/notification")
    public void sendNotification(@RequestBody NotificationRequest notificationRequest);
}
