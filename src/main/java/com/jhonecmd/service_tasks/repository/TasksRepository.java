package com.jhonecmd.service_tasks.repository;

import com.jhonecmd.service_tasks.model.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TasksRepository extends JpaRepository<TasksEntity, UUID> {
    Optional<TasksEntity> findByEmail(String email);
}
