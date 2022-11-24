package com.qrapps.QRAttendance.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qrapps.QRAttendance.BaseModel.Base_User;
import com.qrapps.QRAttendance.Entities.BaseUser;
import com.qrapps.QRAttendance.Entities.User_Course;
import com.qrapps.QRAttendance.ResponseModels.GlobalResponse;
import com.qrapps.QRAttendance.services.UserService;

@RestController
@RequestMapping("/user")
public class User_Controller {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/add")
	public Object addUser(@RequestBody  BaseUser userDetails) {
		System.out.println("BaseUser requset body"+userDetails);
		return  userService.addUser(userDetails);
	
	}
	@GetMapping("/view")
	public Object viewUser(@RequestParam @DefaultValue("0") String id) {
		
		return userService.viewUser(id);
	
	}
	@GetMapping("/viewByName")
	public Object viewByName(@RequestParam @DefaultValue("abc") String id) {
		
		return  userService.viewUserByName(id);
	
	}
	@PostMapping("/update")
	public Object updateUser(@RequestBody  BaseUser userDetails) {
		
		return  userService.updateUser(userDetails);
	
	}
	@GetMapping("/viewAll")
	public Object viewAll() {
		
		return userService.viewAll();
	
	}
	@PostMapping("/addCourse")
	public Object addCourse(@RequestBody  User_Course userDetails) {
		
	return  userService.addCourser(userDetails);
		
	
	}
	
	@PostMapping("/login")
	public Object basicLogin(@RequestBody Login loginData) {
		return userService.isValidUser(loginData.getId(), loginData.getPassword());
		
		
	}
	@PostMapping("/logout")
	public Object basicLogout(@RequestBody String uid) {
		return userService.logout(uid);
		
		
	}


}
class Login{
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}