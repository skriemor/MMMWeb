package com.kissszabo.hu.mmmweb;


import com.kissszabo.hu.mmmweb.controller.MassageController;
import com.kissszabo.hu.mmmweb.dto.MassageUITO;
import com.kissszabo.hu.mmmweb.dto.ReservationUITO;
import com.kissszabo.hu.mmmweb.entity.Massage;
import com.kissszabo.hu.mmmweb.entity.Reservation;
import com.kissszabo.hu.mmmweb.repository.MassageRepository;
import com.kissszabo.hu.mmmweb.repository.ReservationRepository;
import com.kissszabo.hu.mmmweb.service.MassageService;
import com.kissszabo.hu.mmmweb.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public DataSource getDataSource()
    {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:file:C:/temp/test");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }

    @Bean
    CommandLineRunner initDatabase(MassageService mService, ReservationService rService) {
        return args -> {


            MassageUITO uito = new MassageUITO();
            uito.setName("saras");
            uito.setId(0L);
            uito.setLength(15);
            //mService.saveMassage(uito);
            ReservationUITO uito1 = new ReservationUITO();
            uito1.setCustomerEmail("fg@gg.com");
            uito1.setStartDate(LocalDateTime.now());
            uito1.setId(0L);
            uito = mService.getMassageByName(uito.getName());
            uito1.setMassageType(uito);
            uito1.setEndDate(LocalDateTime.now().plusMinutes(uito.getLength()));
            log.info("" + uito1.toString() +"\n" + uito.toString());
            //rService.saveReservation(uito1);

        };

    }


}