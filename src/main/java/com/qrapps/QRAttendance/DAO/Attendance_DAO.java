package com.qrapps.QRAttendance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrapps.QRAttendance.Entities.Attendance;

@Repository
public interface Attendance_DAO  extends JpaRepository<Attendance, Integer>{

}
