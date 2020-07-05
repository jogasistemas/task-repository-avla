package com.todo.taskrepositoryavla.controller;

import com.todo.taskrepositoryavla.entity.User;
import com.todo.taskrepositoryavla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.ACCEPTED);
    }
}
