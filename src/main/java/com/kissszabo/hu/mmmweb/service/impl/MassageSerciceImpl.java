package com.kissszabo.hu.mmmweb.service.impl;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.entity.Massage;
import com.kissszabo.hu.mmmweb.repository.MassageRepository;
import com.kissszabo.hu.mmmweb.service.MassageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional
public class MassageSerciceImpl implements MassageService {
    Logger logger = Logger.getLogger("SERVICE");

    @Autowired
    private MassageRepository repo;

    @Override
    @Transactional
    public MassageUITO saveMassage(MassageUITO massageUITO) {
        var dto = new Massage();
        BeanUtils.copyProperties(massageUITO,dto);
        dto = repo.save(dto);
        BeanUtils.copyProperties(dto,massageUITO);
        return massageUITO;
    }
    @Override
    public List<MassageUITO> getAllMassages() {
        List<MassageUITO> uitoList = new ArrayList<MassageUITO>();
        repo.findAll().stream().forEach(
                mass-> {
                    MassageUITO uito = new MassageUITO();
                    BeanUtils.copyProperties(mass,uito);
                    uitoList.add(uito);
                }
        );
        return uitoList;
    }

    @Override
    public MassageUITO getMassage(MassageUITO massageUITO) {
        var dto = repo.findById(massageUITO.getId());
        var uito = new MassageUITO();
        BeanUtils.copyProperties(dto,uito);
        return uito;
    }

    @Override
    public MassageUITO getMassageByName(String name) {
        var dto = repo.findMassageByName(name);
        var uito = new MassageUITO();
        BeanUtils.copyProperties(dto,uito);
        return uito;
    }
    @Override
    @Transactional
    public void deleteMassage(MassageUITO massageUiTO) {
        repo.deleteById(massageUiTO.getId());
    }
}
