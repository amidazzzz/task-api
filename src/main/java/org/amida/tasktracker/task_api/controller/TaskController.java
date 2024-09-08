package org.amida.tasktracker.task_api.controller;

import lombok.RequiredArgsConstructor;
import org.amida.tasktracker.task_api.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskDTO taskDTO, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(taskService.createTask(user, taskDTO));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        return ResponseEntity.ok(taskService.updateTask(id, taskDetails));
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        return taskService.getAllTasksByUser(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Task task = taskService.getTaskById(user, id);
        return ResponseEntity.ok(task);
    }



}
