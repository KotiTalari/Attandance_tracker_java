package com.qrapps.QRAttendance;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SuppressWarnings("deprecation")
@CrossOrigin(origins = { "http://localhost:4200"},methods = {RequestMethod.GET,RequestMethod.POST})
@SpringBootApplication
@EnableScheduling
public class QrAttendanceApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(QrAttendanceApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
        
		System.out.println("Load Data");
	}
	
	

}
