package com.qrapps.QRAttendance.Interceptor;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.qrapps.QRAttendance.ServiceImp.LoginCache;

@Component
public class QRInterceptor implements HandlerInterceptor {

	@Autowired
	private LoginCache cache;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		
		List<String> url=Arrays.asList("/user/add","/user/login","user/logout");
		String path=request.getRequestURI();
		System.out.println("path"+path);
		

		if(url.contains(path)) {
			System.out.println("url matched");
			return true;
		}		
		String uid=request.getHeader("token");
		System.out.println("token is"+uid);
		return uid==null ? false : cache.isValidUser(uid);

		
	}

	
}
