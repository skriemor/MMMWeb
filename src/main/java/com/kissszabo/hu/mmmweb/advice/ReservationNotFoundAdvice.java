package com.kissszabo.hu.mmmweb.advice;


import com.kissszabo.hu.mmmweb.exception.ReservationNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class ReservationNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ReservationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String reservationNotFoundHandler(ReservationNotFoundException ex) {
        return ex.getMessage();
    }
}