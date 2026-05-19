package com.user.management.security;

import com.user.management.entities.User;
import com.user.management.exceptions.ResourceNotFoundException;
import com.user.management.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
                .findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Email or Password !!"));
    }
}
