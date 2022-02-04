package com.example.rishibhaiya.repository;

import com.example.rishibhaiya.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
}
