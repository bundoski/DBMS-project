package com.example.cinemawebapp.repository.impl;


import com.example.cinemawebapp.bootstrap.DataHolder;
import com.example.cinemawebapp.model.Screening;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScreeningRepositoryImpl {

    public List<Screening> findAll(){
        return DataHolder.screeningList;
    }

    public Optional<Screening> findById(Long screeningId){
        return DataHolder.screeningList
                .stream()
                .filter(s -> s.getId_screening().equals(screeningId))
                .findFirst();
    }

    public void deleteById(Long screeningId){
        DataHolder.screeningList.removeIf(s -> s.getId_screening().equals(screeningId));
    }

    public Screening saveOrUpdate(Screening screening){
        DataHolder.screeningList.add(screening);
        return screening;
    }

}
