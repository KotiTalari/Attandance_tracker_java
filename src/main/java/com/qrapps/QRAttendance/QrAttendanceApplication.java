package com.qrapps.QRAttendance;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

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
