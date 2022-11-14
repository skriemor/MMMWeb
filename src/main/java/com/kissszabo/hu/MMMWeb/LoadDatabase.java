package com.kissszabo.hu.MMMWeb;


import com.kissszabo.hu.MMMWeb.Entitiy.Reservation;
import com.kissszabo.hu.MMMWeb.Repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

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
/*
    @Bean
    CommandLineRunner initDatabase(ReservationRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Reservation("hehe@gmail.com")));
            log.info("Preloading " + repository.save(new Reservation("xd@gmail.com")));
        };
    }

 */
}