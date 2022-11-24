package com.kissszabo.hu.mmmweb.controller;

import java.util.ArrayList;
import java.util.List;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.dto.ReservationUITO;
import com.kissszabo.hu.mmmweb.entity.Reservation;
import com.kissszabo.hu.mmmweb.exception.ReservationNotFoundException;
import com.kissszabo.hu.mmmweb.repository.ReservationRepository;
import com.kissszabo.hu.mmmweb.service.MassageService;
import com.kissszabo.hu.mmmweb.service.ReservationService;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;

@SessionScope
@Controller("reservationController")
class ReservationController {

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

    public void uiSaveReservation() {
        reservationService.saveReservation(this.getReservationUITO());
        getAllReservations();
    }

    private ReservationUITO getReservationUITO() {
        return this.reservationUITO;
    }

    public List<MassageUITO> getUitoList() {
        return uitoList;
    }

    public void setUitoList(List<MassageUITO> uitoList) {
        this.uitoList = uitoList;
    }

    public void setService(MassageService service) {
        this.service = service;
    }

    @PostConstruct
    public void init() {
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

    @PostConstruct
    public void getAllMassages() {
        this.uitoList = service.getAllMassages();
        this.setActionLabel("Add");
    }
    public void deleteMassage(MassageUITO _uito){
        service.deleteMassage(_uito);
        this.getAllMassages();
    }
    public void editMassage(MassageUITO _uito) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(_uito,this.getUito());
    }

    public void setUito(MassageUITO uito) {
        this.uito = uito;
    }


    public MassageUITO getUito() {
        return uito;
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
}