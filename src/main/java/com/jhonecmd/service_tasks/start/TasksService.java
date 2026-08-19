package com.jhonecmd.service_tasks.start;

import com.jhonecmd.service_tasks.model.TasksEntity;
import com.jhonecmd.service_tasks.repository.TasksRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TasksService {

    private final TasksRepository tasksRepository;

    public void save(TasksEntity tasksEntity) {
        tasksRepository.save(tasksEntity);
        return;
    }

}
