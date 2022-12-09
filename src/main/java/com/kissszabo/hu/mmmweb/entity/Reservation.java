package com.kissszabo.hu.mmmweb.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESERVATION")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "massage_id", referencedColumnName = "massage_id", nullable = false)
    private Massage massage;

    @Column(name = "startdate")
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    LocalDateTime startDate;
    @Column(name = "email")
    String customerEmail;
    @Column(name = "enddate")
    @DateTimeFormat(pattern = "yyyy.MM.dd HH:mm")
    LocalDateTime endDate;

    public LocalDateTime getEndDate() {
        return endDate;
    }


    public Reservation(Massage massage, LocalDateTime startDate, String customerEmail) {
        this.massage = massage;
        this.startDate = startDate;
        this.customerEmail = customerEmail;
        this.endDate = startDate;
    }

    public Reservation(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Reservation() {

    }


    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
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

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public Massage getMassage() {
        return massage;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setMassage(Massage massage) {
        this.massage = massage;
    }


}