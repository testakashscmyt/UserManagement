package com.user.management.controller;

import com.user.management.entities.User;

import com.user.management.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

//    register user
    @PostMapping
    public ResponseEntity<User> userRegister(@RequestBody User user){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userServiceImpl.registerUser(user));



    }

//    getAll users

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(this.userServiceImpl.getAllUsers());
    }

//    getUserBy id


    @GetMapping("/{id}")
    public User getuserById(@PathVariable UUID id){
        return this.userServiceImpl.getById(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID id){
        this.userServiceImpl.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

//    update user

    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id,@RequestBody User user){

        System.out.println("update controller"+id +" " +user);
//        is "id" wale "user" ko update krdo
        return this.userServiceImpl.updateUser(id, user);
    }

//    create

//    @PostMapping
//    public User createUser(@RequestBody User user) {
//        return this.userServiceImpl.createUser(user);
//    }
//
//
////    update
//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable int id,@RequestBody User user){
//        return this.userServiceImpl.updateUser(id,user);
//    }
//
////    get single user
//    @GetMapping("/{id}")
//    public User getUserByUserId(@PathVariable ("id") int id) {
//        return this.userServiceImpl.getUserById(id);
//    }
//
//
//    @GetMapping
//    public List<User> getAllUsers() {
//        List<User> allUser = userServiceImpl.getAllUser();
//        return allUser;
//    }


//    getAll


//    delete


}
