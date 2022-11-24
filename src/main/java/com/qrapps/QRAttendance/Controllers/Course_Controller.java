package com.qrapps.QRAttendance.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qrapps.QRAttendance.Entities.Course;
import com.qrapps.QRAttendance.ServiceImp.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class Course_Controller {

	@Autowired
	private CourseServiceImpl courseServiceImpl;
	@PostMapping("/add")	
	public Object addCourse(@RequestBody Course data) {		
		return courseServiceImpl.addEntity(data);
	}
	@GetMapping("/view")	
	public Object viewCourse(@RequestParam String cid) {		
		return courseServiceImpl.viewById(cid);
	}
	@GetMapping("/viewAll")	
	public Object viewAll() {		
		return courseServiceImpl.viewAll();
	}
	
	
}
