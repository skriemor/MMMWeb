package com.kissszabo.hu.mmmweb.service.impl;

import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.entity.Massage;
import com.kissszabo.hu.mmmweb.mapper.MassageTOMapper;
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

    MassageTOMapper mapper = new MassageTOMapper();
    @Autowired
    private MassageRepository repo;

    @Override
    @Transactional
    public MassageUITO saveMassage(MassageUITO massageUITO) {
        return mapper.mDtoToUito(repo.save(mapper.mUitoToDto(massageUITO)));
    }
    @Override
    public List<MassageUITO> getAllMassages() {
        return new ArrayList<MassageUITO>(repo.findAll().stream()
                .map(m -> mapper.mDtoToUito(m)).toList());
    }

    @Override
    public MassageUITO getMassage(MassageUITO massageUITO) {
        return mapper.mDtoToUito(repo.findById(massageUITO.getId()).get());
    }

    @Override
    public MassageUITO getMassageByName(String name) {
         return mapper.mDtoToUito(repo.findMassageByName(name));
    }
    @Override
    @Transactional
    public void deleteMassage(MassageUITO massageUiTO) {
        repo.deleteById(massageUiTO.getId());
    }
}
