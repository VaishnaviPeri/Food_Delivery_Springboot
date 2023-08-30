package com.nexturn.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.Restaurants;
import com.nexturn.demo.Repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository rRepo;

	
	public Restaurants addRestaurant(Restaurants restaurant) throws RestaurantException {
		Optional<Restaurants> ropt = rRepo.findById(restaurant.getRestaurant_id());
		if(ropt.isPresent()) {
			throw new RestaurantException("Restaurant already exists");
		}else {
			return rRepo.save(restaurant);
		}
	}


	public Restaurants updateRestaurant(Restaurants restaurant) throws RestaurantException {
		Optional<Restaurants> opt = rRepo.findById(restaurant.getRestaurant_id());
		if(opt.isPresent()) {
			return rRepo.save(restaurant);
		}else {
			throw new RestaurantException("No such Restaurant exists..");
		}
	}


	public Restaurants removeRestauarant(Integer restaurant_id) throws RestaurantException {
		Optional<Restaurants> opt = rRepo.findById(restaurant_id);
		if(opt.isPresent()) {
			Restaurants restaurant = opt.get();
			rRepo.delete(restaurant);
			return restaurant;
		}else {
			throw new RestaurantException("No Restaurant found with ID: "+restaurant_id);
		}
	}

	
	public Restaurants viewRestaurant(Integer restaurant_id) throws RestaurantException {
		Optional<Restaurants> opt = rRepo.findById(restaurant_id);
		if(opt.isPresent()) {
			Restaurants restaurant = opt.get();
			return restaurant;
		}else {
			throw new RestaurantException("No Restaurant found with ID: "+restaurant_id);
		}
	}

}
