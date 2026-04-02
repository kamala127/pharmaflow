package com.pharmaflow.pharmaflow.service;

import com.pharmaflow.pharmaflow.dto.request.LoginRequest;
import com.pharmaflow.pharmaflow.dto.request.RegisterRequest;
import com.pharmaflow.pharmaflow.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {
    UserResponse register(RegisterRequest request);

    UserResponse login(LoginRequest request);
}
