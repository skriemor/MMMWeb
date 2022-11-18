package com.kissszabo.hu.mmmweb;


import com.kissszabo.hu.mmmweb.controller.MassageController;
import com.kissszabo.hu.mmmweb.entity.Massage;
import com.kissszabo.hu.mmmweb.repository.MassageRepository;
import com.kissszabo.hu.mmmweb.service.MassageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Bean
    CommandLineRunner initDatabase(MassageRepository repository) {
        return args -> {
            //log.info("Preloading " + repository.save(new Massage("hehe@gmail.com",12)));
            //log.info("Preloading " + repository.save(new Massage("xd@gmail.com",15)));
            repository.findAll().stream().forEach(c-> log.info(c.toString()));

        };

    }


}