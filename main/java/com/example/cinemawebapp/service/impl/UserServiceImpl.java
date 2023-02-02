package com.example.cinemawebapp.service.impl;

import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.User;
import com.example.cinemawebapp.model.exception.MovieAlreadyExistsException;
import com.example.cinemawebapp.model.exception.MovieNotFoundException;
import com.example.cinemawebapp.repository.jpa.UserRepository;
import com.example.cinemawebapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listAll() {
       return this.userRepository.findAll()
               .stream()
               .sorted(Comparator.comparing(User::getUsername))
               .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(Long userId) {
        if(this.userRepository.findById(userId).isEmpty()){
            throw new RuntimeException();
        }
        return this.userRepository.findById(userId);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        if(this.userRepository.findByUsername(username).isEmpty()){
            throw new RuntimeException();
        }

        return this.userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(Long id, String username, String password) {
        if(id !=null && findById(id).isPresent()){
            User user = this.userRepository.findById(id).orElseThrow(RuntimeException::new);
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            return userRepository.save(user);
        }
        else if(id != null && findByUsername(username).isPresent() && findById(id).isEmpty()){
            throw new RuntimeException();
        }

        return userRepository.save(new User(id, username, password));

    }

    @Override
    public void deleteById(Long userId) {
        this.userRepository.deleteById(userId);
    }
}
