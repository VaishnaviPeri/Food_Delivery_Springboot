package com.nexturn.demo.Model;




import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="Menu")

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Menu {
	//attributes for menu entity
	
	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int menu_id;
	@Column(name = "dish_name")
	private String dish_name;
	private double dish_price;
	private int quantity;
	private String category;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="restaurant_id")
	private Restaurants restaurant;
	
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name="cart_id")
	private FoodCart foodcart;
	
//	@ManyToOne(cascade= CascadeType.ALL)
//    private List<Menu> menuList;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int menu_id, String dish_name, double dish_price, int quantity, String category, Restaurants restaurant) {
		super();
		this.menu_id = menu_id;
		this.dish_name = dish_name;
		this.dish_price = dish_price;
		this.quantity=quantity;
		this.category = category;
		this.restaurant = restaurant;
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}

	public String getDish_name() {
		return dish_name;
	}

	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}

	public double getDish_price() {
		return dish_price;
	}

	public void setDish_price(double dish_price) {
		this.dish_price = dish_price;
	}
	

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Restaurants getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	

}
