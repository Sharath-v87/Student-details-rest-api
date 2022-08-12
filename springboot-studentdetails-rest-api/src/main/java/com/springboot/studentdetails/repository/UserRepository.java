package com.springboot.studentdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.studentdetails.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserNameOrEmail(String username, String email);
    Optional<User> findByUsername (String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

}