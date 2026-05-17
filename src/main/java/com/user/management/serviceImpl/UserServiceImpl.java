package com.user.management.serviceImpl;

import com.user.management.entities.User;
import com.user.management.services.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    static List<User> userList = new ArrayList();

    static{

        userList.add(new User(12,"Akash","akash@gmail.com","545485","moz"));
        userList.add(new User(13,"Anshul","anshul@gmail.com","545485","delhi"));
        userList.add(new User(14,"Rahul","rahul@gmail.com","545485","kanpur"));

    }

    @Override
    public User createUser(User user) {
        userList.add(user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return  userList.stream()
                .filter(user -> ((User) user).getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userList;
    }
}
