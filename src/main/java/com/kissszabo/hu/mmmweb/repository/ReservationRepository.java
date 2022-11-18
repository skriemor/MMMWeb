package com.kissszabo.hu.mmmweb.repository;

import com.kissszabo.hu.mmmweb.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}