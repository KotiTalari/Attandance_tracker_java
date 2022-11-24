package com.qrapps.QRAttendance.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qrapps.QRAttendance.Entities.Attendance;

import com.qrapps.QRAttendance.ResponseModels.GlobalResponse;
import com.qrapps.QRAttendance.ServiceImp.AttendanceServiceImpl;
import com.qrapps.QRAttendance.ServiceImp.CommonServiceImpl;

@RestController
@RequestMapping("/attend")
public class AttendanceController {

	@Autowired
	private AttendanceServiceImpl service;

	@PostMapping("/register")
	public GlobalResponse registerAttend(@RequestBody Attendance body) {
		try {
			//Object data = serviceFactory.addEntity(body);
			Object data = service.addEntity(body);
			return new GlobalResponse("200", data, "Attendance Recorded Success");	
		}catch(Exception ex) {
			ex.printStackTrace();
			return new GlobalResponse("400",null, "Attendance Record failed");
		}
		
	}
	@GetMapping("/viewAll")
	public GlobalResponse registerAttend() {
		try {
			
			Object data = service.viewAll();
			
			return new GlobalResponse("200", data, "Retrive All");	
		}catch(Exception ex) {
			ex.printStackTrace();
			return new GlobalResponse("400",null, "Retrive Failed");
		}
		
	}
}
