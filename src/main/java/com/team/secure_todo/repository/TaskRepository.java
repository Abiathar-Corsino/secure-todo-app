package com.team.secure_todo.repository;

import com.team.secure_todo.model.Task;
import com.team.secure_todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUser(User user);
}