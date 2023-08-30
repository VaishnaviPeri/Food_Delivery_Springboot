package com.nexturn.demo.Model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int menu_id;
	private String dish_name;
	private double dish_price;
	private int quantity;
	private String category;
	private double cost;
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Menu(int menu_id, String dish_name, double dish_price, int quantity, String category, double cost) {
		super();
		this.menu_id = menu_id;
		this.dish_name = dish_name;
		this.dish_price = dish_price;
		this.quantity = quantity;
		this.category = category;
		this.cost = cost;
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

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", dish_name=" + dish_name + ", dish_price=" + dish_price + ", quantity="
				+ quantity + ", category=" + category + ", cost=" + cost + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
