package com.team.secure_todo.controller;

import com.example.securetodo.model.User;
import com.example.securetodo.repository.TaskRepository;
import com.example.securetodo.repository.UserRepository;
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