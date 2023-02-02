package com.example.cinemawebapp.repository.jpa;

import com.example.cinemawebapp.model.Reservation;
import com.example.cinemawebapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);


}
