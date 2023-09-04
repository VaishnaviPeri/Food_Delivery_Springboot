package com.nexturn.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class RestaurantDto {
	
	private int restaurant_id;
	private String restaurant_name;
	private String restaurant_contact;
	private String restaurant_address;
	private String username;
	private String password;
	public RestaurantDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RestaurantDto(int restaurant_id, String restaurant_name, String restaurant_contact,
			String restaurant_address, String username, String password) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_contact = restaurant_contact;
		this.restaurant_address = restaurant_address;
		this.username = username;
		this.password = password;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public String getRestaurant_name() {
		return restaurant_name;
	}
	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}
	public String getRestaurant_contact() {
		return restaurant_contact;
	}
	public void setRestaurant_contact(String restaurant_contact) {
		this.restaurant_contact = restaurant_contact;
	}
	public String getRestaurant_address() {
		return restaurant_address;
	}
	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
