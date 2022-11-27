package com.kissszabo.hu.mmmweb.mapper;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.entity.Massage;
import org.springframework.beans.BeanUtils;

public class MassageTOMapper {

    private MassageTOMapper mapper;
    public MassageTOMapper(){}

    public MassageTOMapper MassageTOMapper() {
        return mapper==null?new MassageTOMapper():mapper;
    }

    public MassageUITO mDtoToUito(Massage massage) {
        MassageUITO uito = new MassageUITO();
        BeanUtils.copyProperties(massage,uito);
        return uito;
    }

    public Massage mUitoToDto(MassageUITO uito) {
        Massage dto = new Massage();
        BeanUtils.copyProperties(uito,dto);
        return dto;
    }
}
