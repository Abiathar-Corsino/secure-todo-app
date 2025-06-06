package com.team.secure_todo.controller;

import com.team.secure_todo.model.Task;
import com.team.secure_todo.model.User;
import com.team.secure_todo.repository.TaskRepository;
import com.team.secure_todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<Task> getTasks(Authentication auth) {
        logger.info("User {} looking at tasks", auth.getName());
        User user = userRepository.findByEmail(auth.getName()).orElseThrow();
        if (auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return taskRepository.findAll();
        }
        return taskRepository.findByUser(user);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task, Authentication auth) {
        logger.info("User {} making task: {}", auth.getName(), task.getTitle());
        User user = userRepository.findByEmail(auth.getName()).orElseThrow();
        task.setUser(user);
        return taskRepository.save(task);
    }
}
