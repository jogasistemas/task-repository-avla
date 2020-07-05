package com.todo.taskrepositoryavla.service;

import com.todo.taskrepositoryavla.entity.Task;
import com.todo.taskrepositoryavla.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private ITaskRepository taskRepository;

    public List<Task> getAll() {
        return this.taskRepository.findAll();
    }

    public Optional<Task> getById(int id) {
        return this.taskRepository.findById(id);
    }

    public void deleteById(int id) {
        this.taskRepository.deleteById(id);
    }

    public void save(Task task) {
        this.taskRepository.save(task);
    }
}
