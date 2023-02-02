package com.example.cinemawebapp.service.impl;

import com.example.cinemawebapp.model.Screening;
import com.example.cinemawebapp.model.Seat_reserved;
import com.example.cinemawebapp.repository.jpa.SeatReservedRepository;
import com.example.cinemawebapp.service.SeatReservedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatReservedServiceImpl implements SeatReservedService {

    private final SeatReservedRepository seatReservedRepository;

    @Autowired

    public SeatReservedServiceImpl(SeatReservedRepository seatReservedRepository){
        this.seatReservedRepository = seatReservedRepository;
    }

    @Override
    public List<Seat_reserved> listAll() {
        return this.seatReservedRepository.findAll().stream()
                .sorted(Comparator.comparing(Seat_reserved::getId_seat_reserved)).collect(Collectors.toList());
    }

    @Override
    public Optional<Seat_reserved> findById(Long seatReservedId) {
        if(this.seatReservedRepository.findById(seatReservedId).isEmpty()){
            throw new RuntimeException();
        }

        return this.seatReservedRepository.findById(seatReservedId);
    }

    @Override
    public Seat_reserved saveSeatReserved(Long id_seat_reserved, Long id_seat, Long id_screening) {
        if(id_seat_reserved != null && findById(id_seat_reserved).isPresent()){
            Seat_reserved sr = this.seatReservedRepository.findById(id_seat_reserved).orElseThrow(RuntimeException::new);
           //Long id_seat_reserved, Long id_seat, Long id_screening
            sr.setId_seat_reserved(id_seat_reserved);
            sr.setId_seat(id_seat);
            sr.setId_screening(id_screening);
            return seatReservedRepository.save(sr);
        } else if(id_seat_reserved!=null && findById(id_seat_reserved).isEmpty()){
            throw new RuntimeException();
        }
        return this.seatReservedRepository.save(new Seat_reserved(id_seat_reserved, id_seat, id_screening));

    }

    @Override
    public void deleteById(Long seatReservedId) {
        this.seatReservedRepository.deleteById(seatReservedId);
    }
}
