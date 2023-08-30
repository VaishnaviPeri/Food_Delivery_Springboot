package com.nexturn.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class RegisterModel {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int user_id;
	
	private int userName;
	private String password;
	private String mobileNo;
	private String email;
	
	public RegisterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RegisterModel(int user_id, int userName, String password, String mobileNo, String email) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.password = password;
		this.mobileNo = mobileNo;
		this.email = email;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getUserName() {
		return userName;
	}

	public void setUserName(int userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "RegisterModel [user_id=" + user_id + ", userName=" + userName + ", password=" + password + ", mobileNo="
				+ mobileNo + ", email=" + email + "]";
	}
	
	
	

}
