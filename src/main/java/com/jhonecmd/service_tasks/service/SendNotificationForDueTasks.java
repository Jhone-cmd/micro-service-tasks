package com.jhonecmd.service_tasks.service;

import com.jhonecmd.service_tasks.communication.NotificationClient;
import com.jhonecmd.service_tasks.dto.NotificationRequest;
import com.jhonecmd.service_tasks.model.TasksEntity;
import com.jhonecmd.service_tasks.repository.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SendNotificationForDueTasks {

    private final TasksRepository tasksRepository;
    private final NotificationClient notificationClient;

    public void execute() {
        LocalDateTime deadline = LocalDateTime.now().plusDays(1);
        List<TasksEntity> tasks =  tasksRepository.findTasksDueWithInDeadline(deadline);
        for (TasksEntity task : tasks) {
            NotificationRequest request = new NotificationRequest(String.format("Your task '%s' is about to expire.",
                    task.getTitle()),
                    task.getEmail());
            notificationClient.sendNotification(request);
            task.setNotified(true);
        }
    }
}
