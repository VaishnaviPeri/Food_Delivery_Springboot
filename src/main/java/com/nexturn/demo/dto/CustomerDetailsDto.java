package com.nexturn.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsDto {
	private int customer_id;
	private String customer_name;
	private String customer_phone_no;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	public CustomerDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDetailsDto(int customer_id, String customer_name, String customer_phone_no, String address,
			String city, String state, String zipcode) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_phone_no = customer_phone_no;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getCustomer_phone_no() {
		return customer_phone_no;
	}
	public void setCustomer_phone_no(String customer_phone_no) {
		this.customer_phone_no = customer_phone_no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
	
     
}
