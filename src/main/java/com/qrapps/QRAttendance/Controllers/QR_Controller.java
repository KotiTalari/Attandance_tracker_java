package com.qrapps.QRAttendance.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qrapps.QRAttendance.BaseModel.QRStore;
import com.qrapps.QRAttendance.ServiceImp.QRServiceImple;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/qr")
public class QR_Controller {
	
	@Autowired
	public QRServiceImple qRServiceImple;
	
	@PostMapping ( value = "/generate" ,produces = MediaType.IMAGE_JPEG_VALUE)	
	public  @ResponseBody byte[] generateCode(@RequestBody QRStore data) {		
		return qRServiceImple.addEntity(data);
	}
	
	
}
