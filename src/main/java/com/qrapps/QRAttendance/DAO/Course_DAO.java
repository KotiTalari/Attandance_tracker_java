package com.qrapps.QRAttendance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrapps.QRAttendance.Entities.Course;

@Repository
public interface Course_DAO extends JpaRepository<Course, Integer> {

}
