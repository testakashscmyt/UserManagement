package com.user.management.services;

import com.user.management.dtos.UserDto;
import com.user.management.entities.User;
import com.user.management.repository.UserRepo;
import com.user.management.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    static List<User> userList = new ArrayList();

//    static{
//
//        userList.add(new User(12,"Akash","akash@gmail.com","545485","moz"));
//        userList.add(new User(13,"Anshul","anshul@gmail.com","545485","delhi"));
//        userList.add(new User(14,"Rahul","rahul@gmail.com","545485","kanpur"));
//
//    }

    @Override
    public User registerUser(User user) {
        return this.userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers(){
        return this.userRepo.findAll();
    }

    @Override
    public User getById(UUID id) {
        return this.userRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(UUID uuid) {
       this.userRepo.deleteById(uuid);
    }

    @Override
    public User updateUser(UUID id, User user) {
            User user1 = new User();
            user1.setId(id);

            user1.setName(user.getName());
            user1.setContact(user.getContact());
            user1.setEmail(user.getEmail());
            user1.setEnabled(false);
            user1.setPassword(user.getPassword());
            user1.setImage(user.getImage());

            return this.userRepo.save(user1);

    }


//
//    @Override
//    public UserDto createUser(UserDto userDto) {
//        return null;
//    }
//
//    @Override
//    public UserDto updateUser(UserDto userDto, String userId) {
//        return null;
//    }
//
//    @Override
//    public void deleteUser(String userId) {
//
//    }
//
//    @Override
//    public UserDto getUserByEmail(String email) {
//        return null;
//    }
//
//    @Override
//    public UserDto getUserById(String userId) {
//        return null;
//    }
//
//    @Override
//    public List<UserDto> getAllUser() {
//        return List.of();
//    }

//    @Override
//    public User createUser(User user) {
//        userList.add(user);
//        return user;
//    }


//    @Override
//    public User updateUser(int id, User user) {

//        User user1 = userList.stream().filter(u -> u.getId() == id).findAny().orElse(null);
//        user1.setName(user.getName());
//        user1.setAddress(user.getAddress());
//        user1.setEmail(user.getEmail());
//        user1.setContact(user.getContact());
//        return user1;
//    }

//    @Override
//    public User getUserById(int id) {
//        return  userList.stream()
//                .filter(user -> ((User) user).getId() == id)
//                .findFirst()
//                .orElse(null);
//    }

//    @Override
//    public List<User> getAllUser() {
//        return userList;
//    }



}
