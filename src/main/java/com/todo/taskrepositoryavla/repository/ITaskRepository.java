package com.todo.taskrepositoryavla.repository;

import com.todo.taskrepositoryavla.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Integer> {
}
