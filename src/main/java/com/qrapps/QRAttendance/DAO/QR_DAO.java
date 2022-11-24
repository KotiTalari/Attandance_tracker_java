package com.qrapps.QRAttendance.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrapps.QRAttendance.Entities.QRStore;

@Repository
public interface QR_DAO extends JpaRepository<QRStore, Integer> {

}
