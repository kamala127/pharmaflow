package com.pharmaflow.pharmaflow.dto.request;

import com.pharmaflow.pharmaflow.entity.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private Role role;
}
