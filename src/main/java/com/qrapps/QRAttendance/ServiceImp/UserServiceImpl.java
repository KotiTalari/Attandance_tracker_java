
package com.qrapps.QRAttendance.ServiceImp;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qrapps.QRAttendance.BaseModel.Base_User;
import com.qrapps.QRAttendance.DAO.User_Course_DAO;
import com.qrapps.QRAttendance.DAO.User_DAO;
import com.qrapps.QRAttendance.Entities.BaseUser;
import com.qrapps.QRAttendance.Entities.User_Course;
import com.qrapps.QRAttendance.ResponseModels.GlobalResponse;
import com.qrapps.QRAttendance.services.UserService;

@Service
class UseServiceImpl implements UserService{
	
	@Autowired
	private User_DAO userRepo;
	
	@Autowired
	private User_Course_DAO userCourseDao;
	
	@Autowired
	private LoginCache loginStore;
	


	@Override
	public Object addUser(Object object) {	
		
		BaseUser user=(BaseUser)object;
		
		  Optional<BaseUser> fuser = userRepo.findById(user.getId());
		  if(fuser.isPresent()){
			 return  new GlobalResponse("400",null,"user already exits");
			  
		  }		
		  return new GlobalResponse("200", userRepo.save((BaseUser)object),"user created");
		
	}

	@Override
	public Object deleteUser(Object object) {		
		
		 userRepo.delete((BaseUser)object);		 
		 return new GlobalResponse("200", "","deleted successfully");   
	}

	@Override
	public Object viewUser(Object object) {
		
		   Optional<BaseUser> user = userRepo.findById((String)object);
		   if(user.isPresent()) {
			   return new GlobalResponse("200", user.get(),"user details");   
		   }
		   return new GlobalResponse("400",null,"not found");

		
		
	}

	@Override
	public Object viewAll() {
	
		try {
			List<BaseUser> allUsers = userRepo.findAll();
			
			return new GlobalResponse("200",allUsers,"all users");
		}catch (Exception e) {
			// TODO: handle exception
			return new GlobalResponse("400",null,"not found");
		}
		
	}

	@Override
	public Object updateUser(Object object) {
			
		try {			 			
			return new GlobalResponse("200",userRepo.save((BaseUser)object),"all users");
		}catch (Exception e) {
			// TODO: handle exception
			return new GlobalResponse("400",null,"not found");
		}
		
	}
	private BaseUser mapper(Base_User user) {
		BaseUser obj=new BaseUser();
		obj.setActive(true);
		obj.setName(user.getName());
		obj.setPassword("password");
		obj.setType(user.getType());
		return obj;
	}

	@Override
	public Object viewUserByName(Object object) {
		
		

		   Optional<BaseUser> user = userRepo.findByName((String)object);
		   if(user.isPresent()) {
			   return new GlobalResponse("200", user.get(),"user details");   
		   }
		   return new GlobalResponse("400",null,"not found");

	}
	
	public Object isValidUser(String id, String password) {
		System.out.println("id"+id);
		System.out.println("password"+password);
		 Optional<BaseUser> obj = userRepo.findByIdAndPassword(id, password);
		if(obj.isPresent()){
			System.out.println("user in data");
			  String uid=UUID.randomUUID().toString();
			     loginStore.setLogin(id, uid);			     
			     return new GlobalResponse("200",uid,"Login done");
		}
		System.out.println("user is in data");
		return new GlobalResponse("400",null,"Not Valid User");
	   
	}
	public Object logout(Object uid) {
		    loginStore.setLogout((String)uid);
		return new GlobalResponse("200",true,"logout succesfully");
		
	}

	@Override
	public Object addCourser(Object object) {
		// TODO Auto-generated method stub
		User_Course entity=(User_Course)object;
		 User_Course usrCouser = userCourseDao.save(entity);
		  if(usrCouser!=null) {
			   return new GlobalResponse("200", usrCouser,"user details");   
		   }
		   return new GlobalResponse("400",null,"not found");

	}
	
}