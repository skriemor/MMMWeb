package com.kissszabo.hu.mmmweb.entity;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "massage_id")
    @RestResource(path = "massagetype", rel = "massageType")
    Massage massageType;

    Calendar startDate;
    String customerEmail;
    Calendar endDate;


    public Reservation(Massage massageType, Calendar startDate, String customerEmail) {
        this.massageType = massageType;
        this.startDate = startDate;
        this.customerEmail = customerEmail;
        this.endDate = CalculateEndDate(startDate, massageType);
    }

    public Reservation(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Reservation() {

    }


    public void setEndDate() {
        this.endDate = CalculateEndDate(this.startDate, this.massageType);
    }

    private Calendar CalculateEndDate(Calendar startDate, Massage massageType) {
        Calendar endCalDate = startDate;
        endCalDate.add(Calendar.MINUTE, massageType.getLength());
        return endCalDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getStartDate() {
        return startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public Massage getMassageType() {
        return massageType;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setMassageType(Massage massageType) {
        this.massageType = massageType;
    }


}