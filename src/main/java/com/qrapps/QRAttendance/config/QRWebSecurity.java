package com.qrapps.QRAttendance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.qrapps.QRAttendance.Interceptor.QRInterceptor;

@Configuration
public class QRWebSecurity implements  WebMvcConfigurer  {

	@Autowired
	private QRInterceptor qrInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		
		registry.addInterceptor(qrInterceptor);
		WebMvcConfigurer.super.addInterceptors(registry);
		
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST");
    }

}
