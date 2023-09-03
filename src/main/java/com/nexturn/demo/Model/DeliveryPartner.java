package com.nexturn.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class DeliveryPartner {
	
	@Id
	
	private int id;
	private String DiliveryPatnerName;
	private String DiliveryPatneContact;
	private String DiliveryPatnEmail;
	
	@OneToOne
	private User user;

	public DeliveryPartner() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryPartner(int id, String diliveryPatnerName, String diliveryPatneContact, String diliveryPatnEmail,
			User user) {
		super();
		this.id = id;
		DiliveryPatnerName = diliveryPatnerName;
		DiliveryPatneContact = diliveryPatneContact;
		DiliveryPatnEmail = diliveryPatnEmail;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiliveryPatnerName() {
		return DiliveryPatnerName;
	}

	public void setDiliveryPatnerName(String diliveryPatnerName) {
		DiliveryPatnerName = diliveryPatnerName;
	}

	public String getDiliveryPatneContact() {
		return DiliveryPatneContact;
	}

	public void setDiliveryPatneContact(String diliveryPatneContact) {
		DiliveryPatneContact = diliveryPatneContact;
	}

	public String getDiliveryPatnEmail() {
		return DiliveryPatnEmail;
	}

	public void setDiliveryPatnEmail(String diliveryPatnEmail) {
		DiliveryPatnEmail = diliveryPatnEmail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
