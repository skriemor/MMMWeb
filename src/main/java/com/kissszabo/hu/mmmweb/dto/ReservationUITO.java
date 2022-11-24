package com.kissszabo.hu.mmmweb.dto;

import java.io.Serializable;
import java.util.Calendar;

public class ReservationUITO implements Serializable {
        private Long id;
        MassageUITO massageType;
        Calendar startDate;
        String customerEmail;
        Calendar endDate;

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

    public Calendar getStartDate() {
        return startDate;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public void setEndDate(Calendar endDate) {
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
