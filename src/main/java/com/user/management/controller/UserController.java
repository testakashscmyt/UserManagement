package com.user.management.controller;

import com.user.management.dtos.UserDto;

import com.user.management.serviceImpl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.*;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;
    private final ModelMapper modelMapper;

    //create user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImpl.createUser(userDto));
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> allUser = userServiceImpl.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    //    get by user email
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(this.userServiceImpl.getUserByEmail(email));
    }


    //    delete user

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        this.userServiceImpl.deleteUser(userId);
    }


    //    update user

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String userId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userServiceImpl.updateUser(userDto, userId));

    }

    //    get user by id
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable String userId) {
        return ResponseEntity.ok(this.userServiceImpl.getUserById(userId));
    }


//    register user
//    @PostMapping
//    public ResponseEntity<User> userRegister(@RequestBody User user){
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(userServiceImpl.registerUser(user));
//    }


//    getAll users
//    @GetMapping
//    public ResponseEntity<List<User>> getAllUsers() {
//        return ResponseEntity
//                .status(HttpStatus.OK)
//                .body(this.userServiceImpl.getAllUsers());
//    }

////    getUserBy id
//    @GetMapping("/{id}")
//    public User getuserById(@PathVariable UUID id) {
//        return this.userServiceImpl.getById(id);
//    }


//    @DeleteMapping("{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable UUID id) {
//        this.userServiceImpl.deleteUserById(id);
//        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
//    }

//    update user

//    @PutMapping("/{id}")
//    public User updateUser(@PathVariable UUID id, @RequestBody User user) {
//
//        System.out.println("update controller" + id + " " + user);
////        is "id" wale "user" ko update krdo
//        return this.userServiceImpl.updateUser(id, user);
//    }


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


}
