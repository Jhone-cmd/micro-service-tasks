package com.jhonecmd.service_tasks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "tasks")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TasksEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;

    @Column(unique = true)
    private String email;
    private String description;
    private LocalDateTime dueDate;
    private Boolean notified = false;

}
