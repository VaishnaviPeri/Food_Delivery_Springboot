package com.nexturn.demo.Model;

import java.util.ArrayList;
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
@Table(name="Restaurants")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurants {
	
	//declaring the attributes for restaurant entity
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int restaurant_id;
	private String restaurant_name;
	private String manager_name;
	private String restaurant_contact;
	private String restaurant_address;
	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JsonIgnore
//	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Menu> menuList = new ArrayList<>();

	public Restaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurants(int restaurant_id, String restaurant_name, String manager_name, String restaurant_contact,
			String restaurant_address, List<Menu> menuList) {
		super();
		this.restaurant_id = restaurant_id;
		this.restaurant_name = restaurant_name;
		this.manager_name = manager_name;
		this.restaurant_contact = restaurant_contact;
		this.restaurant_address = restaurant_address;
		this.menuList = menuList;
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

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
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

	@Override
	public String toString() {
		return "Restaurants [restaurant_id=" + restaurant_id + ", restaurant_name=" + restaurant_name
				+ ", manager_name=" + manager_name + ", restaurant_contact=" + restaurant_contact
				+ ", restaurant_address=" + restaurant_address + ", menuList=" + menuList + "]";
	}

	
	

	
	
	

}
