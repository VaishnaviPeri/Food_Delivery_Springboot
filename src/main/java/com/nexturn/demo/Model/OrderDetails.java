package com.nexturn.demo.Model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="OrderDetails")


public class OrderDetails {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int order_id;
	private boolean order_status;
	private LocalDateTime order_date;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private FoodCart cart;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonIgnore
	private Bill bill;

	public OrderDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderDetails(int order_id, boolean order_status, LocalDateTime order_date, FoodCart cart, Bill bill) {
		super();
		this.order_id = order_id;
		this.order_status = order_status;
		this.order_date = order_date;
		this.cart = cart;
		this.bill = bill;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public boolean getOrder_status() {
		return order_status;
	}

	public void setOrder_status(boolean order_status) {
		this.order_status = order_status;
	}

	public LocalDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(LocalDateTime order_date) {
		this.order_date = order_date;
	}

	public FoodCart getCart() {
		return cart;
	}

	public void setCart(FoodCart cart) {
		this.cart = cart;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
