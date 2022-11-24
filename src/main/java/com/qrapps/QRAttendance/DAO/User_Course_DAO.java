package com.qrapps.QRAttendance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrapps.QRAttendance.Entities.User_Course;

@Repository
public interface User_Course_DAO  extends JpaRepository<User_Course, Integer>{

	
}
