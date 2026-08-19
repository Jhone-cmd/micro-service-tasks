package com.jhonecmd.service_tasks.controller;

import com.jhonecmd.service_tasks.dto.TasksDTO;
import com.jhonecmd.service_tasks.model.TasksEntity;
import com.jhonecmd.service_tasks.service.TasksService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class ServiceTasksController {

    private final TasksService tasksService;

    @Value("${message:Hello default}")
    private String message;


    @GetMapping("/message")
    public String message(){
        return message;
    }

    @PostMapping()
    public ResponseEntity<Object> save(@RequestBody TasksDTO tasksDTO) {
        try {
            TasksEntity tasks = TasksEntity.builder()
                    .title(tasksDTO.getTitle()).email(tasksDTO.getEmail())
                    .description(tasksDTO.getDescription()).dueDate(tasksDTO.getDueDate()).build();
            tasksService.save(tasks);
            return ResponseEntity.status(HttpStatus.CREATED).body(tasks.getId());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
