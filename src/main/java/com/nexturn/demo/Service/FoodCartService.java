package com.nexturn.demo.Service;

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.FoodCart;

public interface FoodCartService {
	
public FoodCart saveCart(FoodCart cart)throws FoodCartException;
	
	public FoodCart addItem(Integer cartId, Integer itemId)throws FoodCartException,MenuException;
	
	public FoodCart clearCart(Integer cartId)throws FoodCartException;
	
	public FoodCart viewCart(Integer cartId)throws FoodCartException;


}
