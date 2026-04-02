package com.pharmaflow.pharmaflow.serviceImpl;

import com.pharmaflow.pharmaflow.dto.request.LoginRequest;
import com.pharmaflow.pharmaflow.dto.request.RegisterRequest;
import com.pharmaflow.pharmaflow.dto.response.UserResponse;
import com.pharmaflow.pharmaflow.entity.Role;
import com.pharmaflow.pharmaflow.entity.User;
import com.pharmaflow.pharmaflow.exception.BusinessException;
import com.pharmaflow.pharmaflow.exception.ResourceNotFoundException;
import com.pharmaflow.pharmaflow.repository.UserRepository;
import com.pharmaflow.pharmaflow.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse register(RegisterRequest request) {

        log.info("Register request received for email: {}", request.getEmail());
        // 1. Check duplicate email
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            log.warn("Duplicate email found: {}", request.getEmail());
            throw new BusinessException("Email already exists");
        }

        // 2. Create user
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        // 🔥 Encrypt password
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // 3. Save
        userRepository.save(user);
        log.info("User registered successfully with id: {}", user.getId());
        return new UserResponse(user.getId(), user.getName(), user.getEmail(),user.getRole());
    }

    @Override
    public UserResponse login(LoginRequest request) {

        log.info("Login attempt for email: {}", request.getEmail());
        // 1. Find user
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> {

                    log.error("User not found: {}", request.getEmail());
                   return new ResourceNotFoundException("User not found");

                });

        // 2. Match password
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            log.error("Invalid password attempt for email: {}", request.getEmail());
            throw new BusinessException("Invalid credentials");
        }

        log.info("User login successful: {}", request.getEmail());
        // 3. Return user (no token now)
        return new UserResponse(user.getId(), user.getName(), user.getEmail(),user.getRole());
    }
}
