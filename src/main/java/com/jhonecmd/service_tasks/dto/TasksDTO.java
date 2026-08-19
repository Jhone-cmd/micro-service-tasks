package com.jhonecmd.service_tasks.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class TasksDTO {
    private String title;
    private String email;
    private String description;
    private LocalDateTime dueDate;
}
