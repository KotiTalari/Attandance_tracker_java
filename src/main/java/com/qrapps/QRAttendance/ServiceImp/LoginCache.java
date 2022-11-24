package com.qrapps.QRAttendance.ServiceImp;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class LoginCache {

	private Map<String,String> loginUser =new HashMap<String,String>();
	
	public boolean setLogin(String userId, String uid) 
	{
		loginUser.put( uid,userId);
		return true;
	}
	public boolean setLogout(String uid) 
	{
		loginUser.remove(uid);
		return true;
	}
	public boolean isValidUser(String uid) {
		return loginUser.containsKey(uid);
	}
}
