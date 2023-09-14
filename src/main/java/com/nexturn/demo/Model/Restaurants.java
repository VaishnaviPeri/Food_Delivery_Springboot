package com.nexturn.demo.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="Restaurants")

public class Restaurants {
	
	//declaring the attributes for restaurant entity
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int restaurant_id;
	private String restaurant_name;
	private String restaurant_contact;
	private String restaurant_address;

	@OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference("restaurant-menus")
	private List<Menu> menuList = new ArrayList<>();

	
	//for login
		@OneToOne
		private User user;

	
		public Restaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurants(int restaurant_id, String restaurant_name, String restaurant_contact, String restaurant_address,
			List<Menu> menuList, User user) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.restaurant_contact = restaurant_contact;
		this.restaurant_address = restaurant_address;
		this.menuList = menuList;
		this.user = user;
	}

	public int getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getRestaurant_contact() {
		return restaurant_contact;
	}

	public void setRestaurant_contact(String restaurant_contact) {
		this.restaurant_contact = restaurant_contact;
	}

	public String getRestaurant_address() {
		return restaurant_address;
	}

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

	
	
	

}
