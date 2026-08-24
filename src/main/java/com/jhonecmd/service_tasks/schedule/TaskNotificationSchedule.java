package com.jhonecmd.service_tasks.schedule;

import com.jhonecmd.service_tasks.service.SendNotificationForDueTasks;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TaskNotificationSchedule {

    private final SendNotificationForDueTasks sendNotificationForDueTasks;

    @Scheduled(fixedRate = 30000)
    public void checkAndNotifyTasks() {
        sendNotificationForDueTasks.execute();
    }
}
