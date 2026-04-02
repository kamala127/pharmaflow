package com.pharmaflow.pharmaflow.service;

import com.pharmaflow.pharmaflow.entity.User;
import com.pharmaflow.pharmaflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    @Autowired
    private UserRepository repository;


    // Find All User
    public List<User> findAlluserlist(){

        return repository.findAll();
    }
}
