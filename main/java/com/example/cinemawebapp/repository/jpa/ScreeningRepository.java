package com.example.cinemawebapp.repository.jpa;

import com.example.cinemawebapp.model.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScreeningRepository extends JpaRepository<Screening, Long> {


}
