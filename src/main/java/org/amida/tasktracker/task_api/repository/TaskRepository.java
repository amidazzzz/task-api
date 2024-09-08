package org.amida.tasktracker.task_api.repository;

import org.amida.tasktracker.task_api.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    Optional<Task> findByUserIdAndTaskId(Long userId, Long taskId);
}
