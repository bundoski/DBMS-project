package com.example.cinemawebapp.repository.impl;

import com.example.cinemawebapp.bootstrap.DataHolder;
import com.example.cinemawebapp.model.Seat_reserved;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SeatReservedRepositoryImpl {

    public List<Seat_reserved> findAll(){
        return DataHolder.seat_reservedList;
    }

    public Optional<Seat_reserved> findById(Long seatReservedId){
        return DataHolder.seat_reservedList
                .stream()
                .filter(s -> s.getId_seat_reserved().equals(seatReservedId))
                .findFirst();
    }

    public void deleteById(Long seatReservedId){
        DataHolder.seat_reservedList.removeIf(s -> s.getId_seat_reserved().equals(seatReservedId));
    }

    public Seat_reserved saveOrUpdate(Seat_reserved seat_reserved, Long id){
        if(id != null){
            DataHolder.seat_reservedList.removeIf(s -> s.getId_seat_reserved().equals(id));
        }
        DataHolder.seat_reservedList.add(seat_reserved);
        return seat_reserved;
    }
}
