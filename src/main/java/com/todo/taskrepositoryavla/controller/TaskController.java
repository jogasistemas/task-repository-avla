package com.todo.taskrepositoryavla.controller;

import com.todo.taskrepositoryavla.Request.TaskRequest;
import com.todo.taskrepositoryavla.entity.Task;
import com.todo.taskrepositoryavla.entity.User;
import com.todo.taskrepositoryavla.service.TaskService;
import com.todo.taskrepositoryavla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    public ResponseEntity<List<Task>> getTasks() {
        return new ResponseEntity<>(taskService.getAll(), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    public ResponseEntity<Optional<Task>> get(@PathVariable int id) {
        return new ResponseEntity<>(taskService.getById(id), HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CrossOrigin(origins = "*", methods= {RequestMethod.DELETE})
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        boolean status = false;
        if (this.taskService.getById(id).isPresent()) {
            status = true;
            taskService.deleteById(id);
        }
        return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CrossOrigin(origins = "*", methods= {RequestMethod.PUT})
    public ResponseEntity<Boolean> update(@RequestBody TaskRequest request) {
        boolean status = false;
        if (this.taskService.getById(request.getId()).isPresent()) {
            status = true;
            Task task = new Task();
            task.setId(request.getId());
            task.setTitle(request.getTitle());
            task.setDescription(request.getDescription());
            System.out.println("estatus : "+request.getStatus());
            task.setStatus(request.getStatus());
            if (request.getUserId() != 0) {
                int userId = request.getUserId();
                Optional<User> userOptional = this.userService.getById(userId);
                if (userOptional.isPresent()) {
                    task.setUser(userOptional.get());
                }
            }

            
            taskService.save(task);
        }

        return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    public ResponseEntity<Boolean> create(@RequestBody TaskRequest request) {
        boolean status = true;

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(Task.TaskStatus.TODO.ordinal());
        task.setCreateDate(new Date());
        System.out.println("idUser : "+request.getUserId());
        task.setStatus(request.getStatus());
        if (request.getUserId() != 0) {
            int userId = request.getUserId();
            Optional<User> userOptional = this.userService.getById(userId);
            if (userOptional.isPresent()) {
                task.setUser(userOptional.get());
            }
        }
        taskService.save(task);

        return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
    }

 }
