package com.nexturn.demo.dto;

import org.springframework.stereotype.Component;

@Component
public class DeliveryPartnerDto {
	private int id;
	private String deliveryPartnerName;
	private String deliveryPartnerContact;
	private String deliveryPartnerEmail;
	private String username;
	private String password;
	public DeliveryPartnerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryPartnerDto(int id, String deliveryPartnerName, String deliveryPartnerContact,
			String deliveryPartnerEmail, String username, String password) {
		super();
		this.id = id;
		this.deliveryPartnerName = deliveryPartnerName;
		this.deliveryPartnerContact = deliveryPartnerContact;
		this.deliveryPartnerEmail = deliveryPartnerEmail;
		this.username = username;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDeliveryPartnerName() {
		return deliveryPartnerName;
	}
	public void setDeliveryPartnerName(String deliveryPartnerName) {
		this.deliveryPartnerName = deliveryPartnerName;
	}
	public String getDeliveryPartnerContact() {
		return deliveryPartnerContact;
	}
	public void setDeliveryPartnerContact(String deliveryPartnerContact) {
		this.deliveryPartnerContact = deliveryPartnerContact;
	}
	public String getDeliveryPartnerEmail() {
		return deliveryPartnerEmail;
	}
	public void setDeliveryPartnerEmail(String deliveryPartnerEmail) {
		this.deliveryPartnerEmail = deliveryPartnerEmail;
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
