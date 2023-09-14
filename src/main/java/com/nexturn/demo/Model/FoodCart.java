package com.nexturn.demo.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="FoodCart")

public class FoodCart {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    private int cart_id;
	    private int customer_id;
//	    private int menu_id;
	    private int item_quantity;
	    
	    
		public FoodCart() {
			super();
			// TODO Auto-generated constructor stub
		}
		public FoodCart(int id, int cart_id, int customer_id, int item_quantity, Menu menu) {
			super();
			this.id = id;
			this.cart_id = cart_id;
			this.customer_id = customer_id;
//			this.menu_id = menu_id;
			this.item_quantity = item_quantity;
			this.menu = menu;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getCart_id() {
			return cart_id;
		}
		public void setCart_id(int cart_id) {
			this.cart_id = cart_id;
		}
		public int getCustomer_id() {
			return customer_id;
		}
		public void setCustomer_id(int customer_id) {
			this.customer_id = customer_id;
		}
//		public int getMenu_id() {
//			return menu_id;
//		}
//		public void setMenu_id(int menu_id) {
//			this.menu_id = menu_id;
//		}
		public int getItem_quantity() {
			return item_quantity;
		}
		public Menu getMenu() {
			return menu;
		}
		public void setMenu(Menu menu) {
			this.menu = menu;
		}
		public void setItem_quantity(int item_quantity) {
			this.item_quantity = item_quantity;
		}
	
	    

	    

	    
	    
	    

	    
	    
	    
	    
	    
	    
	    //	    @OneToMany(cascade = CascadeType.MERGE)
//    @JsonManagedReference("customer-cart")
//	    @JoinColumn(name="customer_id")
//	    private List<Customer> customer;
//    
//	    

	    @ManyToOne
//    @JsonManagedReference("cart-menu")
	    @JoinColumn(name="menu_id")
//	    private List<Menu> menuList= new ArrayList<>();
	    private Menu menu;

//(cascade = CascadeType.MERGE)
		
   
//        @ManyToMany
//        @JoinTable(
//                name = "foodcart_menu",
//                joinColumns = @JoinColumn(name = "foodcart_id"),
//                inverseJoinColumns = @JoinColumn(name = "menu_id")
//            )
//        private List<Menu> menuList;
        
        //(mappedBy = "foodCart")
	    
	    
	    
//	@OneToOne(mappedBy = "foodCart",cascade=CascadeType.ALL)
//    @JsonIgnore
//    private Bill bill;
    
    
	
	

	
    
    
    
}
