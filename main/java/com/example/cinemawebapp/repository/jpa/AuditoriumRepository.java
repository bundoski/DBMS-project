package com.example.cinemawebapp.repository.jpa;

import com.example.cinemawebapp.model.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
        Optional<Auditorium> findByName(String auditoriumName);

}
