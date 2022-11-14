package com.kissszabo.hu.MMMWeb.Exception;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(Long id) {
        super("Could not find reservation " + id);
    }
}