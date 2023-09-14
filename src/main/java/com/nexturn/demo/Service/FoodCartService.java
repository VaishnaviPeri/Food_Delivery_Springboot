package com.nexturn.demo.Service;

import java.util.List;

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.FoodCart;

public interface FoodCartService {
	
public List<FoodCart> saveCart(List<FoodCart> foodcart)throws FoodCartException;
	
//	public FoodCart addItem(Integer cartId, Integer itemId)throws FoodCartException,MenuException;
	
	public FoodCart clearCart(Integer cartId)throws FoodCartException;
	
	public FoodCart viewCart(Integer cartId)throws FoodCartException;


}
