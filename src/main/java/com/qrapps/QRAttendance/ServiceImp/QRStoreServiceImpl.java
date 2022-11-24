package com.qrapps.QRAttendance.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;

import com.qrapps.QRAttendance.DAO.QR_DAO;
import com.qrapps.QRAttendance.Entities.QRStore;
import com.qrapps.QRAttendance.services.CommonService;

public class QRStoreServiceImpl implements CommonService {

	@Autowired
	private QR_DAO qrStore;
	
	@Override
	public Object addEntity(Object object) {
		// TODO Auto-generated method stub
		return qrStore.save( (QRStore)object );
	}

	@Override
	public Object deleteEntity(Object object) {
		// TODO Auto-generated method stub
		 qrStore.delete((QRStore)object );
		 return "deleted";
	}

	@Override
	public Object viewEntityById(Object object) {
		// TODO Auto-generated method stub
		return qrStore.findById( ((QRStore)object).getId() );
	}

	@Override
	public Object updateEntity(Object object) {
		// TODO Auto-generated method stub
		return qrStore.save( (QRStore)object );
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
