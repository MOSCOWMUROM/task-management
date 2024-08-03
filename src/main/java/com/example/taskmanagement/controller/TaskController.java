package com.example.taskmanagement.controller;

import com.example.taskmanagement.model.*;
import com.example.taskmanagement.security.JwtUtil;
import com.example.taskmanagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
        );
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getEmail());
        final String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping("/tasks/author/{authorId}")
    public List<Task> getTasksByAuthor(@PathVariable Long authorId) {
        User author = userService.getUserById(authorId);
        return taskService.getTasksByAuthor(author);
    }

    @GetMapping("/tasks/assignee/{assigneeId}")
    public List<Task> getTasksByAssignee(@PathVariable Long assigneeId) {
        User assignee = userService.getUserById(assigneeId);
        return taskService.getTasksByAssignee(assignee);
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @GetMapping("/tasks/{taskId}/comments")
    public List<Comment> getCommentsByTask(@PathVariable Long taskId) {
        Task task = taskService.getTaskById(taskId);
        return commentService.getCommentsByTask(task);
    }

    // Другие методы для управления задачами и комментариями
}
