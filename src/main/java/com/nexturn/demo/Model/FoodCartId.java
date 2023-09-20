package com.nexturn.demo.Model;

import java.io.Serializable;
import java.util.Objects;

public class FoodCartId implements Serializable{
	
	private int cart_id;
//	private int item_quantity;
	private int id;
	public FoodCartId(int cart_id,  int id) {
		super();
		this.cart_id = cart_id;
//		this.item_quantity = item_quantity;
		this.id=id;
	}
	public FoodCartId() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(cart_id, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FoodCartId other = (FoodCartId) obj;
		return cart_id == other.cart_id  && id==other.id;
	}

	

}
