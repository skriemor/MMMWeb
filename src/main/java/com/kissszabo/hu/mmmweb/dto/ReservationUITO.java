package com.kissszabo.hu.mmmweb.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Calendar;

public class ReservationUITO implements Serializable {
    private Long id;
    MassageUITO massageType;
    LocalDateTime startDate;
    String customerEmail;
    LocalDateTime endDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MassageUITO getMassageType() {
        return massageType;
    }

    public void setMassageType(MassageUITO massageType) {
        this.massageType = massageType;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public LocalDateTime getEndDate() {
        return this.endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "ReservationUITO{" +
                "id=" + id +
                ", massageType=" + massageType +
                ", startDate=" + startDate +
                ", customerEmail='" + customerEmail + '\'' +
                ", endDate=" + endDate +
                '}';
    }
}
