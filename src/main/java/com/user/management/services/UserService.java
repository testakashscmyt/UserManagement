package com.user.management.services;

import com.user.management.entities.User;

import java.util.*;

public interface UserService {

//create

    User createUser(User user);


//update

    User updateUser(int id, User user);

//delete


//get by id

    User getUserById(int id);


//getAll

    List<User> getAllUser();

}
