package com.user.management.services;

import com.user.management.dtos.UserDto;
import com.user.management.entities.User;

import java.util.*;

public interface UserService {


//    register user



    public User registerUser(User user);

    public List<User> getAllUsers();

    public User getById(UUID id);

    public void deleteUserById(UUID uuid);

    public User updateUser(UUID id, User user);












    //create user
//    UserDto createUser(UserDto userDto);
//
//
////update
//
//    UserDto updateUser(UserDto userDto, String userId);
//
////delete
//
//    void deleteUser(String userId);
//
////    get user by email
//
//    UserDto getUserByEmail(String email);
//
//    //get by id
//    UserDto getUserById(String userId);
//
//
//    //getAll
//    List<UserDto> getAllUser();

}
