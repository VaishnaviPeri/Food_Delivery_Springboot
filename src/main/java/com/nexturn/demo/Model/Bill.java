package com.nexturn.demo.Model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
	
	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="cart_id")
	private FoodCart foodCart;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(int bill_id, LocalDateTime bill_date, double bill_total, int quantity, FoodCart foodCart) {
		super();
		this.bill_id = bill_id;
		this.bill_date = bill_date;
		this.bill_total = bill_total;
		this.quantity = quantity;
		this.foodCart = foodCart;
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

	public FoodCart getFoodCart() {
		return foodCart;
	}

	public void setFoodCart(FoodCart foodCart) {
		this.foodCart = foodCart;
	}


	
	
	
	
	
	
	

}
