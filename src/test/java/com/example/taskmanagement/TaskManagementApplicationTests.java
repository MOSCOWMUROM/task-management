package com.example.taskmanagement;

import com.example.taskmanagement.model.*;
import com.example.taskmanagement.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TaskManagementApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateUser() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        User savedUser = userRepository.save(user);
        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    void testCreateTask() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        User savedUser = userRepository.save(user);

        Task task = new Task();
        task.setTitle("Test Task");
        task.setDescription("This is a test task.");
        task.setStatus("PENDING");
        task.setPriority("HIGH");
        task.setAuthor(savedUser);

        Task savedTask = taskRepository.save(task);
        assertThat(savedTask).isNotNull();
        assertThat(savedTask.getId()).isGreaterThan(0);
    }
}