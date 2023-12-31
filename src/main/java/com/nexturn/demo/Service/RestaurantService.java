package com.nexturn.demo.Service;


import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.Restaurants;

public interface RestaurantService {
	
//	public Restaurants addRestaurant(Restaurants restaurant) throws RestaurantException;
	
	public Restaurants updateRestaurant(Integer restaurant_id,Restaurants restaurant) throws RestaurantException;
	
	public Restaurants removeRestauarant(Integer restaurant_id) throws RestaurantException;
	
	public Restaurants viewRestaurant(Integer restautrant_id) throws RestaurantException;
	
	public Restaurants viewRestaurantByName(String restaurant_name) throws RestaurantException;
	
//	public Menu deleteByDishName(String dish_name, Integer restaurant_id) throws MenuException;

	
	//	public Restaurants validateRestaurant(String manager_name, String manager_password) throws RestaurantException;
	

}
