package com.user.management.serviceImpl;

import com.user.management.AuthService;
import com.user.management.dtos.UserDto;
import com.user.management.repository.UserRepo;
import com.user.management.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto registerUser(UserDto userDto) {

//        verifying the email
//        verify password
//        assign role
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return this.userService.createUser(userDto);
    }
}
