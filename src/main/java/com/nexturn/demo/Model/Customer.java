package com.nexturn.demo.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Customer")

@NoArgsConstructor
@Data
@AllArgsConstructor
@ToString

public class Customer {
	//defining user attributes for user entity
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int customer_id;
	private String customer_name;
	private String customer_password;
	private String customer_email_id;
	private String customer_phone_no;
	private String customer_gender;
	private String address;
	private String city;
	private String state;
	private String zipcode;
	
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart foodCart;
	
//	
//	@OneToOne(cascade = CascadeType.ALL)
//	private Address address;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int customer_id, String customer_name, String customer_password, String customer_email_id,
			String customer_phone_no, String customer_gender, String address, String city, String state, String zipcode,
			FoodCart foodCart) {
		super();
		this.customer_id = customer_id;
		this.customer_name = customer_name;
		this.customer_password = customer_password;
		this.customer_email_id = customer_email_id;
		this.customer_phone_no = customer_phone_no;
		this.customer_gender = customer_gender;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.foodCart = foodCart;
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

	public String getCustomer_password() {
		return customer_password;
	}

	public void setCustomer_password(String customer_password) {
		this.customer_password = customer_password;
	}

	public String getCustomer_email_id() {
		return customer_email_id;
	}

	public void setCustomer_email_id(String customer_email_id) {
		this.customer_email_id = customer_email_id;
	}

	public String getCustomer_phone_no() {
		return customer_phone_no;
	}

	public void setCustomer_phone_no(String customer_phone_no) {
		this.customer_phone_no = customer_phone_no;
	}

	public String getCustomer_gender() {
		return customer_gender;
	}

	public void setCustomer_gender(String customer_gender) {
		this.customer_gender = customer_gender;
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

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}

	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_password="
				+ customer_password + ", customer_email_id=" + customer_email_id + ", customer_phone_no="
				+ customer_phone_no + ", customer_gender=" + customer_gender + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", zipcode=" + zipcode + ", foodCart=" + foodCart + "]";
	}


	
	
	
	
	
	
	

}
