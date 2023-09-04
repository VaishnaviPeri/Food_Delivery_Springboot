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
@Table(name="FoodCart")

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FoodCart {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int cart_id;
	

//    @OneToOne(cascade=CascadeType.ALL)
//    JsonIgnore
//    private Bill bill;
	
    @OneToOne(cascade= CascadeType.ALL)
    @JsonIgnore
    private Customer customer;
    
    @OneToMany(cascade= CascadeType.ALL)
    private List<Menu> menuList;
    
    
	public FoodCart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodCart(int cart_id, Customer customer, List<Menu> menuList) {
		super();
		this.cart_id = cart_id;
		this.customer = customer;
		this.menuList = menuList;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	@Override
	public String toString() {
		return "FoodCart [cart_id=" + cart_id + ", customer=" + customer + ", menuList=" + menuList + "]";
	}
    
    
    
    
}
