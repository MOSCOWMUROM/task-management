package com.example.taskmanagement.service;

import com.example.taskmanagement.model.*;
import com.example.taskmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByAuthor(User author) {
        return taskRepository.findByAuthor(author);
    }

    public List<Task> getTasksByAssignee(User assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    public Task getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if (task.isEmpty()) {
            throw new RuntimeException("Task not found with id: " + taskId);
        }
        return task.get();
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }
}


