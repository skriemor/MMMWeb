package com.kissszabo.hu.mmmweb.util;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.service.MassageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@Service
public class MassageConverter implements Converter {


    @Autowired
    private MassageService service;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return service.getMassageByName(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof MassageUITO) {
            MassageUITO massage = (MassageUITO) o;
            return massage.getName();
        } else {
            String error =
                    "The object is not an instance of MassageUITO";
            throw new ClassCastException(error);
        }
    }
}
