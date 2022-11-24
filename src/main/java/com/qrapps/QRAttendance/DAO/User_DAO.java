package com.qrapps.QRAttendance.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qrapps.QRAttendance.Entities.BaseUser;

@Repository
public interface User_DAO extends JpaRepository<BaseUser,String> {

	public Optional<BaseUser>  findByName(String name);
	public  Optional<BaseUser> findByIdAndPassword(String id,String password); 
}
