package com.example.cinemawebapp.service.impl;

import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.Screening;
import com.example.cinemawebapp.repository.jpa.ScreeningRepository;
import com.example.cinemawebapp.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScreeningServiceImpl  implements ScreeningService {

    private final ScreeningRepository screeningRepository;

    @Autowired
    public ScreeningServiceImpl(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }


    @Override
    public List<Screening> listAll() {
        return this.screeningRepository.findAll().stream()
                .sorted(Comparator.comparing(Screening::getId_screening)).collect(Collectors.toList());
    }


    @Override
    public Optional<Screening> findById(Long screeningId) {
        if(this.screeningRepository.findById(screeningId).isEmpty()){
            throw new RuntimeException();
        }

        return this.screeningRepository.findById(screeningId);
    }

    @Override
    public Screening saveScreening(Long id_screening, LocalDateTime screening_start, Long id_auditorium, Long id_movie) {
        if(id_screening != null && findById(id_screening).isPresent()){
            Screening s = this.screeningRepository.findById(id_screening).orElseThrow(RuntimeException::new);
           // Long id_screening, LocalDateTime screening_start,
             //       Long id_auditorium, Long id_movie
            s.setId_screening(id_screening);
            s.setScreening_start(screening_start);
            s.setId_auditorium(id_auditorium);
            s.setId_movie(id_movie);
            return screeningRepository.save(s);
        } else if(id_screening != null && findById(id_screening).isEmpty()){
            throw new RuntimeException();
        }

        return this.screeningRepository.save(new Screening(id_screening, screening_start,
                id_auditorium, id_movie));
    }

    @Override
    public void deleteById(Long screeningId) {
        this.screeningRepository.deleteById(screeningId);
    }
}
