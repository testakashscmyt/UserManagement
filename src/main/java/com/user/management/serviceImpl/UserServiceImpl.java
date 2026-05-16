package com.user.management.serviceImpl;

import com.user.management.entities.User;
import com.user.management.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List userList = new ArrayList();

    public UserServiceImpl(){

        userList.add(new User(12,"Akash","akash@gmail.com","545485","moz"));
        userList.add(new User(13,"Anshul","anshul@gmail.com","545485","delhi"));
        userList.add(new User(14,"Rahul","rahul@gmail.com","545485","kanpur"));

    }


    @Override
    public void createUser(User user) {
        userList.add(user);
    }

    @Override
    public User getUserById(int id) {

        userList.stream().forEach(System.out::println);
        return new User();

    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }
}
