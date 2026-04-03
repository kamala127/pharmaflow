package com.pharmaflow.pharmaflow.repository;

import com.pharmaflow.pharmaflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

//    User findByuserName(String name);

//    User findByphoneNumber(String username);
}
