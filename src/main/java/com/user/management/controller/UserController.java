package com.user.management.controller;

import com.user.management.entities.User;
import com.user.management.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

//    create

    @PostMapping
    public User createUser(@RequestBody User user) {
        return this.userServiceImpl.createUser(user);
    }


//    update
    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,@RequestBody User user){
        return this.userServiceImpl.updateUser(id,user);
    }

//    get single user
    @GetMapping("/{id}")
    public User getUserByUserId(@PathVariable ("id") int id) {
        return this.userServiceImpl.getUserById(id);
    }


    @GetMapping
    public List<User> getAllUsers() {
        List<User> allUser = userServiceImpl.getAllUser();
        return allUser;
    }


//    getAll


//    delete


}
