package com.kissszabo.hu.mmmweb.controller;

import java.util.ArrayList;
import java.util.List;
import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.dto.ReservationUITO;
import com.kissszabo.hu.mmmweb.service.MassageService;
import com.kissszabo.hu.mmmweb.service.ReservationService;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;
import javax.annotation.PostConstruct;
import java.io.Serializable;




@SessionScope
@Controller("reservationController")
public class ReservationController implements Serializable {

    private List<SortMeta> sortBy;
    @Autowired
    ReservationService reservationService;
    @Autowired
    MassageService massageService;
    private String actionLabel;
    private MassageUITO massageUITO;



    private ReservationUITO reservationUITO;
    private List<MassageUITO> massageUITOS;
    private List<ReservationUITO> reservationUITOS;

    public void editReservation(ReservationUITO ruito) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(ruito,this.getReservationUITO());
    }
    public void uiSaveReservation() {
        reservationService.saveReservation(this.getReservationUITO());
        getAllReservations();
        this.setReservationUITO(new ReservationUITO());

    }
    public void deleteReservation(ReservationUITO uito) {
        reservationService.DeleteReservation(uito);
        getAllReservations();
    }

    private void getAllReservations() {
        this.setMassageUITOS(massageService.getAllMassages());
        this.setReservationUITOS(reservationService.getAllReservations());
        this.setActionLabel("Add");
    }


    @PostConstruct
    public void init() {
        getAllReservations();
        sortBy = new ArrayList<>();
        sortBy.add(SortMeta.builder()
                .field("id")
                .order(SortOrder.ASCENDING)
                .build());
/*
        sortBy.add(SortMeta.builder()
                .field("name")
                .order(SortOrder.ASCENDING)
                .priority(1)
                .build());
*/
    }


    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setSortBy(List<SortMeta> sortBy) {
        this.sortBy = sortBy;
    }

    public List<SortMeta> getSortBy() {
        return sortBy;
    }

    public ReservationUITO getReservationUITO() {
        return this.reservationUITO;
    }

    public void setReservationUITO(ReservationUITO reservationUITO) {
        this.reservationUITO = reservationUITO;
    }

    public void setReservationUITOS(List<ReservationUITO> reservationUITOS) {
        this.reservationUITOS = reservationUITOS;
    }

    public List<ReservationUITO> getReservationUITOS() {
        return reservationUITOS;
    }

    public List<MassageUITO> getMassageUITOS() {
        return massageUITOS;
    }

    public void setMassageUITOS(List<MassageUITO> massageUITOS) {
        this.massageUITOS = massageUITOS;
    }
}