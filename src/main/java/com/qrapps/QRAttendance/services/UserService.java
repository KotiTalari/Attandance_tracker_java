package com.qrapps.QRAttendance.services;

 public  interface UserService {

	Object addUser(Object object);
	Object deleteUser(Object object);
	Object viewUser(Object object);
	Object viewAll();
	Object updateUser(Object object);
	Object viewUserByName(Object object);
	Object isValidUser(String id, String password) ;
	Object addCourser(Object object);
	Object logout(Object object);
}
 
