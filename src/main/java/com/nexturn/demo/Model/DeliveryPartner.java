package com.nexturn.demo.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryPartner {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String deliveryPartnerName;
	private String deliveryPartnerContact;
	private String deliveryPartnerEmail;
	
	@OneToOne(cascade=CascadeType.ALL)
	private User user;

//	public DeliveryPartner() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public DeliveryPartner(int id, String deliveryPartnerName, String deliveryPartnerContact,
//			String deliveryPartnerEmail, User user) {
//		super();
//		this.id = id;
//		this.deliveryPartnerName = deliveryPartnerName;
//		this.deliveryPartnerContact = deliveryPartnerContact;
//		this.deliveryPartnerEmail = deliveryPartnerEmail;
//		this.user = user;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getDeliveryPartnerName() {
//		return deliveryPartnerName;
//	}
//
//	public void setDeliveryPartnerName(String deliveryPartnerName) {
//		this.deliveryPartnerName = deliveryPartnerName;
//	}
//
//	public String getDeliveryPartnerContact() {
//		return deliveryPartnerContact;
//	}
//
//	public void setDeliveryPartnerContact(String deliveryPartnerContact) {
//		this.deliveryPartnerContact = deliveryPartnerContact;
//	}
//
//	public String getDeliveryPartnerEmail() {
//		return deliveryPartnerEmail;
//	}
//
//	public void setDeliveryPartnerEmail(String deliveryPartnerEmail) {
//		this.deliveryPartnerEmail = deliveryPartnerEmail;
//	}
//
//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	
	

}
