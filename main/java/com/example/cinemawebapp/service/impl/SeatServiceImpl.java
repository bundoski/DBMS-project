package com.example.cinemawebapp.service.impl;

import com.example.cinemawebapp.model.Seat;
import com.example.cinemawebapp.model.Seat_reserved;
import com.example.cinemawebapp.repository.jpa.SeatRepository;
import com.example.cinemawebapp.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;
    @Autowired
    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public List<Seat> listAll() {
        return this.seatRepository.findAll().stream()
                .sorted(Comparator.comparing(Seat::getId_seat)).collect(Collectors.toList());
    }

    @Override
    public Optional<Seat> findById(Long seatId) {
        if(this.seatRepository.findById(seatId).isEmpty()){
            throw new RuntimeException();
        }
        return this.seatRepository.findById(seatId);
    }

    @Override
    public Seat saveSeat(Long id_seat, Integer number_seat, Integer row_seat, Long id_auditorium) {
        if(id_seat != null && findById(id_seat).isPresent()){
            Seat s = this.seatRepository.findById(id_seat).orElseThrow(RuntimeException::new);
            //Long id_seat_reserved, Long id_seat, Long id_screening
            s.setId_seat(id_seat);
            s.setNumber_seat(number_seat);
            s.setRow_seat(row_seat);
            s.setId_seat(id_auditorium);
            return seatRepository.save(s);
        } else if(id_seat!=null && findById(id_seat).isEmpty()){
            throw new RuntimeException();
        }
        return this.seatRepository.save(new Seat(id_seat, number_seat, row_seat, id_auditorium));
    }

    @Override
    public void deleteById(Long seatId) {
        this.seatRepository.deleteById(seatId);
    }
}
