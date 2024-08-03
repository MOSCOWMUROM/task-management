package com.example.taskmanagement.repository;

import com.example.taskmanagement.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAuthor(User author);
    List<Task> findByAssignee(User assignee);
}