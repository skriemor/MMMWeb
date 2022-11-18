package com.kissszabo.hu.mmmweb.controller;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.repository.MassageRepository;
import com.kissszabo.hu.mmmweb.service.MassageService;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SessionScope
@Controller("massageController")
public class MassageController implements Serializable {

    Logger logger = Logger.getLogger("MASCON");
    private List<SortMeta> sortBy;
    @Autowired
    MassageService service;

    private String actionLabel;
    private MassageUITO uito;
    private List<MassageUITO> uitoList;

    public void uiSaveMassage() {
        service.saveMassage(this.uito);
        getAllMassages();
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
