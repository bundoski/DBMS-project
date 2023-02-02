package com.example.cinemawebapp.service.impl;


import com.example.cinemawebapp.model.Auditorium;
import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.User;
import com.example.cinemawebapp.model.exception.AuditoriumAlreadyExistsException;
import com.example.cinemawebapp.model.exception.AuditoriumNotFoundException;
import com.example.cinemawebapp.repository.jpa.AuditoriumRepository;
import com.example.cinemawebapp.repository.jpa.UserRepository;
import com.example.cinemawebapp.service.AuditoriumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditoriumServiceImpl implements AuditoriumService {

    private final AuditoriumRepository auditoriumRepository;
    private final UserRepository userRepository;

    @Autowired
    public AuditoriumServiceImpl(AuditoriumRepository auditoriumRepository, UserRepository userRepository){
        this.auditoriumRepository = auditoriumRepository;
        this.userRepository = userRepository;

    }

    @Override
    public List<Auditorium> findAll() {
        return this.auditoriumRepository.findAll();
    }

    @Override
    public List<Auditorium> listAll() {
        return this.auditoriumRepository.findAll().stream().sorted(Comparator.comparing(
                Auditorium::getName_auditorium
        )).collect(Collectors.toList());
    }

    @Override
    public Optional<Auditorium> findById(Long auditoriumId) {
        if(this.auditoriumRepository.findById(auditoriumId).isEmpty()){
            throw new AuditoriumNotFoundException();
        }
        return this.auditoriumRepository.findById(auditoriumId);
    }

    @Override
    public Optional<Auditorium> findByName(String name) {
        return this.auditoriumRepository.findByName(name);
    }

    @Override
    public Auditorium saveAuditorium(Long id_auditorium, String name_auditorium, Long num_seats) {
       if(id_auditorium != null && findById(id_auditorium).isPresent()){
           Auditorium auditorium = this.auditoriumRepository.findById(id_auditorium)
                   .orElseThrow(AuditoriumNotFoundException::new);
           auditorium.setId_auditorium(id_auditorium);
            auditorium.setName_auditorium(name_auditorium);
            auditorium.setNum_seats(num_seats);
            return auditoriumRepository.save(auditorium);
       }
       else if(id_auditorium != null && findByName(name_auditorium).isPresent() && findById(id_auditorium).isEmpty()){
           throw new AuditoriumAlreadyExistsException(name_auditorium);
       }
       return this.auditoriumRepository.save(new Auditorium(id_auditorium, name_auditorium, num_seats));
    }

    @Override
    public void deleteById(Long courseId) {

        this.auditoriumRepository.deleteById(courseId);
    }

    @Override
    public Auditorium save(Auditorium auditorium) {
        Auditorium a = new Auditorium(auditorium.getId_auditorium(), auditorium.getName_auditorium(),
                auditorium.getNum_seats());
        return this.auditoriumRepository.save(a);
    }
}
