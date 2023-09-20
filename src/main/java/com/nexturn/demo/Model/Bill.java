package com.nexturn.demo.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Bill")

public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bill_id;
	private LocalDateTime bill_date;
	private double bill_total;
	private int quantity;
	
	private int cart_id;
	
//	@OneToMany
//	@JoinColumn(name="cart_id")
//	private List<FoodCart> foodCart= new ArrayList<>();

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

public Bill(int bill_id, LocalDateTime bill_date, double bill_total, int quantity, int cart_id) {
	super();
	this.bill_id = bill_id;
	this.bill_date = bill_date;
	this.bill_total = bill_total;
	this.quantity = quantity;
	this.cart_id = cart_id;
}

public int getBill_id() {
	return bill_id;
}

public void setBill_id(int bill_id) {
	this.bill_id = bill_id;
}

public LocalDateTime getBill_date() {
	return bill_date;
}

public void setBill_date(LocalDateTime bill_date) {
	this.bill_date = bill_date;
}

public double getBill_total() {
	return bill_total;
}

public void setBill_total(double bill_total) {
	this.bill_total = bill_total;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public int getCart_id() {
	return cart_id;
}

public void setCart_id(int cart_id) {
	this.cart_id = cart_id;
}

	

	


	
	
	
	
	
	
	

}
