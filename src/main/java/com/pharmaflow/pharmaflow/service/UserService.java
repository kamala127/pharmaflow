package com.pharmaflow.pharmaflow.service;

import com.pharmaflow.pharmaflow.entity.User;
import com.pharmaflow.pharmaflow.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserService {



   final private UserRepository repository;


    // Find All User
    public List<User> findAlluserlist(){

        return repository.findAll();
    }


}
