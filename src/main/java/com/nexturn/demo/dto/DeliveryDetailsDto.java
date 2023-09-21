package com.nexturn.demo.dto;

import org.springframework.stereotype.Component;

@Component

public class DeliveryDetailsDto {
	
	private int id;
	private String deliveryPartnerName;
	private String deliveryPartnerContact;
	
	public DeliveryDetailsDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeliveryDetailsDto(int id, String deliveryPartnerName, String deliveryPartnerContact) {
		super();
		this.id = id;
		this.deliveryPartnerName = deliveryPartnerName;
		this.deliveryPartnerContact = deliveryPartnerContact;
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

	
}
