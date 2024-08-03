package com.example.taskmanagement.service;

import com.example.taskmanagement.model.*;
import com.example.taskmanagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getCommentsByTask(Task task) {
        return commentRepository.findByTask(task);
    }

}
