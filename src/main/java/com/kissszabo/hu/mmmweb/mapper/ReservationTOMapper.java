package com.kissszabo.hu.mmmweb.mapper;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.dto.ReservationUITO;
import com.kissszabo.hu.mmmweb.entity.Massage;
import com.kissszabo.hu.mmmweb.entity.Reservation;
import org.springframework.beans.BeanUtils;

public class ReservationTOMapper {

    private ReservationTOMapper mapper;
    public ReservationTOMapper(){}

    public ReservationTOMapper ReservationTOMapper() {
        return mapper==null?new ReservationTOMapper():mapper;
    }

    public ReservationUITO rDtoToUito(Reservation reservation) {
        ReservationUITO uito = new ReservationUITO();
        MassageUITO massageUITO = new MassageUITO();
        BeanUtils.copyProperties(reservation.getMassage(),massageUITO);
        BeanUtils.copyProperties(reservation,uito);
        uito.setMassageType(massageUITO);
        return uito;
    }

    public Reservation rUitoToDto(ReservationUITO uito) {
        Reservation dto = new Reservation();
        Massage massageDto = new Massage();
        BeanUtils.copyProperties(uito,dto);
        BeanUtils.copyProperties(uito.getMassageType(),massageDto);
        dto.setMassage(massageDto);
        return dto;
    }

}
