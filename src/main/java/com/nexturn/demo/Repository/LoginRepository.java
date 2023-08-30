package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.LoginModel;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel, Integer> {
	
	public LoginModel findByUserNameAndPassword(String user_name,String user_password);

}
