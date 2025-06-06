package com.team.secure_todo.controller;

import com.team.secure_todo.model.User;
import com.team.secure_todo.repository.TaskRepository;
import com.team.secure_todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Authentication auth, Model model) {
        User user = userRepository.findByEmail(auth.getName()).orElseThrow();
        model.addAttribute("userEmail", auth.getName());
        model.addAttribute("tasks", taskRepository.findByUser(user));
        return "home";
    }
}