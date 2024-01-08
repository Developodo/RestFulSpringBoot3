package com.carlosserrano.controller;

import com.carlosserrano.model.User;
import com.carlosserrano.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService service;
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = service.getAllUsers();
        return ResponseEntity.ok(users);
        //return new ResponseEntity<List<User>>(users, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") int id){
        User user = service.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user){
        User end = service.createOrUpdateUser(user);
        return ResponseEntity.ok(end);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id){
        service.deleteUser(id);
    }

}
