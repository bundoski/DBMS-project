package com.example.cinemawebapp.repository.impl;


import com.example.cinemawebapp.bootstrap.DataHolder;
import com.example.cinemawebapp.model.Reservation;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepositoryImpl {

    public List<Reservation> findAll(){
        return DataHolder.reservationList;
    }

    public Optional<Reservation> findById(Long reservationId){
        return DataHolder.reservationList.stream()
                .filter(r -> r.getId_reservation().equals(reservationId)).findFirst();
    }

    public Reservation saveOrUpdate(Reservation reservation){
        DataHolder.reservationList.add(reservation);
        return reservation;
    }

}
