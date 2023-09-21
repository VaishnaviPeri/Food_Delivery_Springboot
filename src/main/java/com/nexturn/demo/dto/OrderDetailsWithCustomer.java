package com.nexturn.demo.dto;

import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.OrderDetails;

public class OrderDetailsWithCustomer {
	
	private CustomerDto customer;
	private OrderDetails orderDetails;
	private Menu menu;
	public OrderDetailsWithCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetailsWithCustomer(CustomerDto customer, OrderDetails orderDetails, Menu menu) {
		super();
		this.customer = customer;
		this.orderDetails = orderDetails;
		this.menu = menu;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public OrderDetails getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	
}
