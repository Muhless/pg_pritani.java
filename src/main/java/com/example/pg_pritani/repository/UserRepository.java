package com.example.pg_pritani.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.pg_pritani.model.User;

@Repository
public interface UserRepository {
     Optional<User> findByUsername(String username);
}
