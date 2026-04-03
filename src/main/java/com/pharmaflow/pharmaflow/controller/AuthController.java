package com.pharmaflow.pharmaflow.controller;

import com.pharmaflow.pharmaflow.config.JwtUtil;
import com.pharmaflow.pharmaflow.dto.request.LoginRequest;
import com.pharmaflow.pharmaflow.dto.request.RegisterRequest;
import com.pharmaflow.pharmaflow.dto.response.UserResponse;
import com.pharmaflow.pharmaflow.entity.User;
import com.pharmaflow.pharmaflow.repository.UserRepository;
import com.pharmaflow.pharmaflow.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        return jwtUtil.generateToken(request.getEmail());
    }




}
