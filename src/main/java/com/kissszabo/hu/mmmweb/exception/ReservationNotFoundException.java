package com.kissszabo.hu.mmmweb.exception;

public class ReservationNotFoundException extends RuntimeException {

    public ReservationNotFoundException(Long id) {
        super("Could not find reservation " + id);
    }
}