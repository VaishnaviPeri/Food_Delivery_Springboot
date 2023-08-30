package com.nexturn.demo.Service;

import com.nexturn.demo.ExceptionHandling.AuthorizationException;
import com.nexturn.demo.Model.LoginModel;

public interface LoginModelService {
	
	public LoginModel authenticate(String user_name, String user_password) throws AuthorizationException;

}
