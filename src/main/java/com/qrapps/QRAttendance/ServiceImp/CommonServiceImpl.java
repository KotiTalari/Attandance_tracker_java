package com.qrapps.QRAttendance.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.qrapps.QRAttendance.services.CommonService;

@Component
public class CommonServiceImpl implements CommonService{
	@Autowired
	private ApplicationContext context;

	@Override
	public Object addEntity(Object object) {
		String cls=object.getClass().getName();
		String name=cls.substring(cls.lastIndexOf('.')+1, cls.length()).toLowerCase();
		JpaRepository store=(JpaRepository) context.getBean(name+"_D");
		return store.save(object);
	}

	@Override
	public Object deleteEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object viewEntityById(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object updateEntity(Object object) {
		// TODO Auto-generated method stub
		return null;
	}
	public Object viewAll(Object object) {
		String cls=object.getClass().getName();
		String name=cls.substring(cls.lastIndexOf('.')+1, cls.length()).toLowerCase();
		JpaRepository store=(JpaRepository) context.getBean(name+"_D");
		return store.findAll();
	}

	@Override
	public Object viewAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object viewById(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

}
