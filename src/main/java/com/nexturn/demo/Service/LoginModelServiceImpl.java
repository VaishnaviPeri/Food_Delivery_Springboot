package com.nexturn.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.AuthorizationException;
import com.nexturn.demo.Model.LoginModel;
import com.nexturn.demo.Repository.LoginRepository;

@Service
public class LoginModelServiceImpl implements LoginModelService{
	
	@Autowired
	LoginRepository loginRepo;

	public LoginModel authenticate(String user_name, String user_password) throws AuthorizationException {
		return  loginRepo.findByUserNameAndPassword(user_name,user_password);
	}
	
}
