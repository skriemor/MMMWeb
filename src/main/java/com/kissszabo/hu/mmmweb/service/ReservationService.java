package com.kissszabo.hu.mmmweb.service;

import com.kissszabo.hu.mmmweb.dto.ReservationUITO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReservationService {
    List<ReservationUITO> getAllReservations ();
    public ReservationUITO saveReservation(ReservationUITO uito);
    ReservationUITO getReservation(ReservationUITO uito);
    void DeleteReservation(ReservationUITO uito);
}
