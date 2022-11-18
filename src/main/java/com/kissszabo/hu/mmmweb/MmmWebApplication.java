package com.kissszabo.hu.mmmweb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MmmWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmmWebApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(MmmWebApplication.class);


}
