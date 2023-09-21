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
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="FoodCart")
@IdClass(FoodCartId.class)

public class FoodCart {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id;
	    @Id
	    private int cart_id;

	    private int item_quantity;
	    
	    @ManyToOne
	    @JoinColumn(name="customer_id")
	    private Customer customer;
	  
	    @ManyToOne   
	    @JoinColumn(name="menu_id")
	    private Menu menu;
	    
	   @ManyToOne
	   @JoinColumn(name="order_id")
	   private OrderDetails orderDetails;  
	   
	   
	   
		public FoodCart() {
			super();
			// TODO Auto-generated constructor stub
		}



		public FoodCart(int id, int cart_id, int item_quantity, Customer customer, Menu menu,
				OrderDetails orderDetails) {
			super();
			this.id = id;
			this.cart_id = cart_id;
			this.item_quantity = item_quantity;
			this.customer = customer;
			this.menu = menu;
			this.orderDetails = orderDetails;
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



		public int getItem_quantity() {
			return item_quantity;
		}



		public void setItem_quantity(int item_quantity) {
			this.item_quantity = item_quantity;
		}



		public Customer getCustomer() {
			return customer;
		}



		public void setCustomer(Customer customer) {
			this.customer = customer;
		}



		public Menu getMenu() {
			return menu;
		}



		public void setMenu(Menu menu) {
			this.menu = menu;
		}



		public OrderDetails getOrderDetails() {
			return orderDetails;
		}



		public void setOrderDetails(OrderDetails orderDetails) {
			this.orderDetails = orderDetails;
		}
		
	    
	    
	    
	    
	   

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
