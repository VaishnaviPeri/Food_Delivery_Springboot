package com.nexturn.demo.Service;

import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.Restaurants;

public interface RestaurantService {
	
	public Restaurants addRestaurant(Restaurants restaurant) throws RestaurantException;
	
	public Restaurants updateRestaurant(Restaurants restaurant) throws RestaurantException;
	
	public Restaurants removeRestauarant(Integer restaurant_id) throws RestaurantException;
	
	public Restaurants viewRestaurant(Integer restautrant_id) throws RestaurantException;
	

}
