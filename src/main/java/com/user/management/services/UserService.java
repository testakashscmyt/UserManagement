package com.user.management.services;

import com.user.management.entities.User;

import java.util.*;

public interface UserService {

//create

    void createUser(User user);


//update


//delete


//get by id

    User getUserById(int id);


//getAll

    List<User> getAllUser();

}
