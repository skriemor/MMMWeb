package com.kissszabo.hu.mmmweb.controller;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.repository.MassageRepository;
import com.kissszabo.hu.mmmweb.service.MassageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import javax.annotation.PostConstruct;
import java.util.List;

@SessionScope
@Controller("massageController")
public class MassageController {
    @Autowired
    MassageService service;

    private String actionLabel;
    private MassageUITO uito;
    private List<MassageUITO> uitoList;

    public void uiSaveMassage() {
        service.saveMassage(this.uito);
        getAllMassages();
    }
    @PostConstruct
    public void getAllMassages() {
        this.uitoList.addAll(service.getAllMassages());
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
}
