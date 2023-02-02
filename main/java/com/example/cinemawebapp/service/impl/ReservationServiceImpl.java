package com.example.cinemawebapp.service.impl;

import com.example.cinemawebapp.model.Movie;
import com.example.cinemawebapp.model.Reservation;
import com.example.cinemawebapp.repository.jpa.ReservationRepository;
import com.example.cinemawebapp.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    @Override
    public List<Reservation> listAll(){
        return this.reservationRepository.findAll().stream().sorted(Comparator.comparing(Reservation::getId_reservation)).collect(Collectors.toList());
    }

    @Override
    public Optional<Reservation> findById(Long reservationId) {
        if(this.reservationRepository.findById(reservationId).isEmpty()){
            throw new RuntimeException();
        }
        return this.reservationRepository.findById(reservationId);
    }


    @Override
    public Reservation saveReservation(Long id_reservation, int active, Integer price_eur, LocalDateTime datum_rezervacija, Long id_korisnik, Long id_seat, Long id_seat_reserved, Long id_screening) {

            Reservation reservation = (Reservation) this.reservationRepository.findById(id_reservation).orElseThrow(RuntimeException::new);
            reservation.setId_reservation(id_reservation);
            reservation.setActive(active);
            reservation.setPrice_eur(price_eur);
    //Long id_reservation, int active, Integer price_eur,
            // LocalDateTime datum_rezervacija, Long id_korisnik, Long id_seat,
            // Long id_seat_reserved, Long id_screening
            reservation.setDatum_rezervacija(datum_rezervacija);
            reservation.setId_korisnik(id_korisnik);
            reservation.setId_seat(id_seat);
            reservation.setId_seat_reserved(id_seat_reserved);
            reservation.setId_screening(id_screening);

        return this.reservationRepository.save(new Reservation(id_reservation, active, price_eur, datum_rezervacija, id_korisnik, id_seat, id_seat_reserved, id_screening));
    }

    @Override
    public void deleteById(Long reservationId) {
        this.reservationRepository.deleteById(reservationId);
    }

    @Override
    public Reservation save(Reservation reservation){
        Reservation r = new Reservation(reservation.getId_reservation(), reservation.getActive(),
                reservation.getPrice_eur(), reservation.getDatum_rezervacija(),
                reservation.getId_korisnik(), reservation.getId_seat(), reservation.getId_seat_reserved()
                , reservation.getId_screening());
        return this.reservationRepository.save(r);
    }


}
