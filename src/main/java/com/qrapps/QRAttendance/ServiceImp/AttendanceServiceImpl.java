package com.qrapps.QRAttendance.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrapps.QRAttendance.DAO.Attendance_DAO;
import com.qrapps.QRAttendance.Entities.Attendance;
import com.qrapps.QRAttendance.services.CommonService;

@Component
public class AttendanceServiceImpl implements CommonService {

	@Autowired
	private Attendance_DAO dao;
	
	@Override
	public Object addEntity(Object object) {		
		Attendance attend=(Attendance)object;
		return dao.save(attend);
	}

	@Override
	public Object deleteEntity(Object object) {
		// TODO Auto-generated method stub
		Attendance attend=(Attendance)object;
		 dao.delete(attend);
		return "deleted sucessfully";
	}

	@Override
	public Object viewEntityById(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object viewAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Object viewById(Object object) {
		// TODO Auto-generated method stub
		return dao.findById(Integer.parseInt((String)object));
	}

}
