package com.user.management.serviceImpl;

import com.user.management.dtos.UserDto;
import com.user.management.entities.Provider;
import com.user.management.entities.User;
import com.user.management.exceptions.ResourceNotFoundException;
import com.user.management.helper.UserHelper;
import com.user.management.repository.UserRepo;
import com.user.management.services.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final ModelMapper modelMapper;

    static List<User> userList = new ArrayList();

//    static{
//
//        userList.add(new User(12,"Akash","akash@gmail.com","545485","moz"));
//        userList.add(new User(13,"Anshul","anshul@gmail.com","545485","delhi"));
//        userList.add(new User(14,"Rahul","rahul@gmail.com","545485","kanpur"));
//
//    }
//
//    @Override
//    public User registerUser(User user) {
//        return this.userRepo.save(user);
//    }
//
//    @Override
//    public List<User> getAllUsers() {
//        return this.userRepo.findAll();
//    }

//    @Override
//    public User getById(UUID id) {
//        return this.userRepo.findById(id).orElse(null);
//    }

//    @Override
//    public void deleteUserById(UUID uuid) {
//        this.userRepo.deleteById(uuid);
//    }

//    @Override
//    public User updateUser(UUID id, User user) {
//        User user1 = new User();
//        user1.setId(id);
//
//        user1.setName(user.getName());
//        user1.setContact(user.getContact());
//        user1.setEmail(user.getEmail());
//        user1.setEnabled(false);
//        user1.setPassword(user.getPassword());
//        user1.setImage(user.getImage());
//
//        return this.userRepo.save(user1);
//
//    }


    @Override
    @Transactional
    public UserDto createUser(UserDto userDto) {
        if (userDto.getEmail() == null || userDto.getEmail().isBlank()) {
            throw new IllegalArgumentException("Email is required");
        }

        if (userRepo.existsByEmail(userDto.getEmail())) {
            throw new IllegalArgumentException("User with given email is already exists");
        }
//            if you have extra checks --- put here
//            converting the dto to entity
        User user = modelMapper.map(userDto, User.class);
//            roles assign krenge to new user---for authorization
//            ToDo
        user.setProvider(userDto.getProvider() != null ? userDto.getProvider() : Provider.LOCAL);
        User savedUser = userRepo.save(user);

        return modelMapper.map(savedUser, UserDto.class);


    }


    @Override
    public UserDto updateUser(UserDto userDto, String userId) {

        UUID uid = UserHelper.parseUUID(userId);
        User existingUser = this.userRepo
                .findById(uid)
                .orElseThrow(() -> new ResourceNotFoundException("User with this id does not exixst in the system"));

//        we are not going to change email id for this project
        if (userDto.getName() != null) existingUser.setName(userDto.getName());
        if (userDto.getImage() != null) existingUser.setImage(userDto.getImage());
        if (userDto.getProvider() != null) existingUser.setProvider(userDto.getProvider());
//        TODO: change password updation logic
        if (userDto.getPassword() != null) existingUser.setPassword(userDto.getPassword());
        existingUser.setEnabled(userDto.isEnabled());
        existingUser.setUpdatedAt(Instant.now());
        User updatedUser = userRepo.save(existingUser);

        return modelMapper.map(updatedUser, UserDto.class);

    }

    @Override
    public void deleteUser(String userId) {
        UUID uuid = UserHelper.parseUUID(userId);
        User user = userRepo.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("User with this id is not present in the database"));
        userRepo.delete(user);
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto getUserById(String userId) {
        User user = userRepo.findById(UserHelper.parseUUID(userId)).orElseThrow(() -> new ResourceNotFoundException("User with given id is not present in the database"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> list = userRepo.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .toList();
        return list;
    }

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
