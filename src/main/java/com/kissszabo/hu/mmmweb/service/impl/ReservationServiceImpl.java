package com.kissszabo.hu.mmmweb.service.impl;

import com.kissszabo.hu.mmmweb.dto.ReservationUITO;
import com.kissszabo.hu.mmmweb.mapper.ReservationTOMapper;
import com.kissszabo.hu.mmmweb.repository.ReservationRepository;
import com.kissszabo.hu.mmmweb.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ReservationServiceImpl implements ReservationService {
    ReservationTOMapper mapper = new ReservationTOMapper();
    @Autowired
    ReservationRepository repo;

    @Override
    public List<ReservationUITO> getAllReservations() {
        return new ArrayList<ReservationUITO>(repo.findAll().stream()
                .map(r ->  mapper.rDtoToUito(r))
                .toList());
    }
//This could potentially be dysfunctional due to relational database
    /*
    @Override
    public ReservationUITO saveReservation(ReservationUITO uito) {
        repo.save(mapper.rUitoToDto(uito));
        return uito;
    }
*/

    @Override
    public ReservationUITO saveReservation(ReservationUITO uito) {
        return mapper.rDtoToUito(repo.save(mapper.rUitoToDto(uito)));
    }
    @Override
    public ReservationUITO getReservation(ReservationUITO uito) {
        return  mapper.rDtoToUito(repo.findById(uito.getId()).get());
    }

    @Override
    @Transactional
    public void DeleteReservation(ReservationUITO uito) {
        repo.deleteById(uito.getId());
    }


}
