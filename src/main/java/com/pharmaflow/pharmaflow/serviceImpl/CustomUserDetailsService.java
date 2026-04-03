package com.pharmaflow.pharmaflow.serviceImpl;

import com.pharmaflow.pharmaflow.dto.response.UserResponse;
import com.pharmaflow.pharmaflow.repository.UserRepository;
import com.pharmaflow.pharmaflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        com.pharmaflow.pharmaflow.entity.User user = userRepository
                .findByEmail(username)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword()) // MUST be encoded
                .roles(user.getRole().name()) // assuming enum
                .build();
    }
}
