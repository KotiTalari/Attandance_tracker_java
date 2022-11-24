package com.qrapps.QRAttendance.Schedulers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.qrapps.QRAttendance.DAO.QR_DAO;
import com.qrapps.QRAttendance.Entities.QRStore;



@Component
public class QRScheduler {
	
	@Autowired
	private QR_DAO qrDAO;
	@Scheduled(fixedDelayString = "${qr.generete.time}")
	public void reportCurrentTime() {
		
		List<QRStore> objects = qrDAO.findAll();
		
		List<QRStore> updatedObjects= objects.stream().map( e ->{
			String otherData=e.getOtherData();
			otherData.concat("__"+System.currentTimeMillis());
			e.setOtherData(otherData);		
			return  e;
		}).collect(Collectors.toList());
		
		qrDAO.saveAll(updatedObjects);
		System.out.println("from scheduler job");
	}
	

}
