package com.qrapps.QRAttendance.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.qrapps.QRAttendance.BaseModel.AttandanceDto;
import com.qrapps.QRAttendance.Controllers.User_Controller;
import com.qrapps.QRAttendance.DAO.Attendance_DAO;
import com.qrapps.QRAttendance.DAO.Course_DAO;
import com.qrapps.QRAttendance.DAO.User_DAO;
import com.qrapps.QRAttendance.Entities.Attendance;
import com.qrapps.QRAttendance.Entities.BaseUser;
import com.qrapps.QRAttendance.Entities.Course;
import com.qrapps.QRAttendance.services.CommonService;

@Component
public class AttendanceServiceImpl implements CommonService {

	@Autowired
	private Attendance_DAO dao;
	
	@Autowired
	private User_DAO userDao;
	
	@Autowired
	private Course_DAO courseDao;
	
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
		List<Attendance> lisOfAtt = dao.findAll();
		List<AttandanceDto> listOfDao =  new ArrayList<>();
		int num = 1;
		System.out.println("Attendance "+lisOfAtt);
		for(Attendance attendance : lisOfAtt) {
			AttandanceDto dto =  new AttandanceDto();
			dto.setSerialNum(num);
			dto.setSid(attendance.getUid());
			Optional<BaseUser> findById = userDao.findById(attendance.getUid());
			if(findById.isPresent()) {
				dto.setSname(findById.get().getName());
			}
			Optional<Course> findById2 = courseDao.findById(Integer.valueOf(attendance.getCid()));
			if(findById2.isPresent()) {
				dto.setCourseName(findById2.get().getName());
			}
			dto.setDate(attendance.getScanTime().toString());
			
			listOfDao.add(dto);
		}
		
		return listOfDao;
	}

	@Override
	public Object viewById(Object object) {
		// TODO Auto-generated method stub
		return dao.findById(Integer.parseInt((String)object));
	}

}
