package com.kissszabo.hu.MMMWeb.Repository;

import com.kissszabo.hu.MMMWeb.Entitiy.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}