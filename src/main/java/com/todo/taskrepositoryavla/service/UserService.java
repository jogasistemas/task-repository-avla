package com.todo.taskrepositoryavla.service;

import com.todo.taskrepositoryavla.entity.User;
import com.todo.taskrepositoryavla.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public Optional<User> getById(int userId) {
        return this.userRepository.findById(userId);
    }
}
