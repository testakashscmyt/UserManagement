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
        this.userServiceImpl.createUser(user);
        return new User();
    }


//    update

//    get single user

    @GetMapping
    public User getUserByUserId(@PathVariable Integer id) {

        this.userServiceImpl.getUserById(id);
        return new User();

    }


    @GetMapping
    public List<User> getAllUsers() {
        List<User> allUser = userServiceImpl.getAllUser();
        return allUser;
    }


//    getAll


//    delete


}
