package com.qrapps.QRAttendance.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrapps.QRAttendance.DAO.Course_DAO;
import com.qrapps.QRAttendance.Entities.Course;
import com.qrapps.QRAttendance.services.CommonService;

@Component
public class CourseServiceImpl implements CommonService {

	@Autowired
	private Course_DAO course;
	@Override
	public Object addEntity(Object object) {
		// TODO Auto-generated method stub
		return course.save((Course)object);
	}

	@Override
	public Object deleteEntity(Object object) {
		// TODO Auto-generated method stub
		 course.delete((Course)object);
		 return "deleted";
	}

	@Override
	public Object viewEntityById(Object object) {
		// TODO Auto-generated method stub		
		return course.findById(((Course)object).getId());
	}

	@Override
	public Object viewAll() {
		// TODO Auto-generated method stub		
		return course.findAll();
	}

	

	@Override
	public Object updateEntity(Object object) {
		// TODO Auto-generated method stub
		return course.save((Course)object);
	}

	

	@Override
	public Object viewById(Object object) {
		// TODO Auto-generated method stub
		int id=(Integer)object;
		return course.findById(id);
	}
	
	public Object viewById(String object) {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(object);
		return course.findById(id);
	}

}
