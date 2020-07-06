package com.todo.taskrepositoryavla.repository;

import com.todo.taskrepositoryavla.entity.Task;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITaskRepository extends JpaRepository<Task, Integer> {

//	@Query("SELECT c.userId FROM Task a JOIN User c where a.user.userId=c.userId")
//	List<Task> listarAll();
}
