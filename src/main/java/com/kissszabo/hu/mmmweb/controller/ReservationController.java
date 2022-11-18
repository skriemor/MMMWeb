package com.kissszabo.hu.mmmweb.controller;

import java.util.List;

import com.kissszabo.hu.mmmweb.entity.Reservation;
import com.kissszabo.hu.mmmweb.exception.ReservationNotFoundException;
import com.kissszabo.hu.mmmweb.repository.ReservationRepository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ReservationController {

    private final ReservationRepository repository;

    ReservationController(ReservationRepository repository) {
        this.repository = repository;
    }



    @GetMapping("/reservation")
    List<Reservation> all() {
        return repository.findAll();
    }


    @PostMapping("/reservation")
    Reservation newReservation(@RequestBody Reservation newReservation) {
        return repository.save(newReservation);
    }

    // Single item

    @GetMapping("/reservation/{id}")
    Reservation one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));
    }

    @PutMapping("/reservation/{id}")
    Reservation replaceReservation(@RequestBody Reservation newReservation, @PathVariable Long id) {

        return repository.findById(id)
                .map(reservation -> {
                    reservation.setCustomerEmail(newReservation.getCustomerEmail());
                    reservation.setStartDate(newReservation.getStartDate());
                    reservation.setMassageType(newReservation.getMassageType());
                    reservation.setEndDate();
                    return repository.save(reservation);
                })
                .orElseGet(() -> {
                    newReservation.setId(id);
                    return repository.save(newReservation);
                });
    }

    @DeleteMapping("/reservation/{id}")
    void deleteReservation(@PathVariable Long id) {
        repository.deleteById(id);
    }
}