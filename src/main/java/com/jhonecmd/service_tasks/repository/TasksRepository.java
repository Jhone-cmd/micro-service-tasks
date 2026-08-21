package com.jhonecmd.service_tasks.repository;

import com.jhonecmd.service_tasks.model.TasksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, UUID> {
    Optional<TasksEntity> findByEmail(String email);
    @Query("SELECT t from tasks t where t.dueDate <= :dealine AND t.notified = false")
    List<TasksEntity> findTasksDueWithInDeadline(LocalDateTime deadline);
}
