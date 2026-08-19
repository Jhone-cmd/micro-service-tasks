package com.jhonecmd.service_tasks.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "tasks")
@Data
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;

    @Column(unique = true)
    private String email;
    private String description;
    private LocalDateTime dueDate;
    private Boolean notified;

}
