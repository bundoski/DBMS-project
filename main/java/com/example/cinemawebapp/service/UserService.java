package com.example.cinemawebapp.service;

import com.example.cinemawebapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> listAll();
    Optional<User> findById(Long userId);
    Optional<User> findByUsername(String username);
    User saveUser(Long id, String username, String password);
    void deleteById(Long userId);
}
