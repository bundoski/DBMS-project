package com.example.cinemawebapp.repository.impl;


import com.example.cinemawebapp.bootstrap.DataHolder;
import com.example.cinemawebapp.model.Seat;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SeatRepositoryImpl {

    public List<Seat> findAll(){
        return DataHolder.seatList;
    }

    public Optional<Seat> findById(Long seatId){
        return DataHolder.seatList
                .stream()
                .filter(s -> s.getId_seat().equals(seatId))
                .findFirst();
    }

    public void deleteById(Long seatId){
        DataHolder.seatList.removeIf(s -> s.getId_seat().equals(seatId));
    }

    public Seat saveOrUpdate(Seat seat, Long id){
        if(id!=null){
            DataHolder.seatList.removeIf(s -> s.getId_seat().equals(id));
        }
        DataHolder.seatList.add(seat);
        return seat;
    }
}
