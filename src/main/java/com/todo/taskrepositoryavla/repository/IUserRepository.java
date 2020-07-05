package com.todo.taskrepositoryavla.repository;

import com.todo.taskrepositoryavla.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
