package com.kissszabo.hu.MMMWeb;

import com.kissszabo.hu.MMMWeb.Entitiy.Massage;
import com.kissszabo.hu.MMMWeb.Entitiy.Reservation;
import com.kissszabo.hu.MMMWeb.Repository.MassageRepository;
import com.kissszabo.hu.MMMWeb.Repository.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Calendar;


@SpringBootApplication
public class MmmWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmmWebApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(MmmWebApplication.class);


}
