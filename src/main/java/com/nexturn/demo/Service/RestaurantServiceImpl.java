package com.nexturn.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.Bill;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.Restaurants;
import com.nexturn.demo.Model.User;
import com.nexturn.demo.Repository.MenuRepository;
import com.nexturn.demo.Repository.RestaurantRepository;
import com.nexturn.demo.Repository.UserRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	RestaurantRepository rRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	MenuRepository menuRepo;
	
   
     Restaurants restaurant;
	
//	public Restaurants addRestaurant(Restaurants restaurant) throws RestaurantException {
//		Integer restaurantId=restaurant.getRestaurant_id();
//		Optional<Restaurants> ropt = rRepo.findById(restaurant.getRestaurant_id());
//		if(ropt.isPresent()) {
//			throw new RestaurantException("Restaurant already exists");
//		}else {
//			User user = restaurant.getUser();
//	        
//	        // Check if the User exists or not
//	        if (user.getId() == 0) {
//	            // User doesn't exist in the database, so save it first
//	            User savedUser = userRepo.save(user); // Assuming userRepository is the repository for User
//	            restaurant.setUser(savedUser); // Set the saved User in the restaurant
//	        }
//	        
//			restaurant.setRestaurant_name(restaurant.getRestaurant_name());
//			restaurant.setRestaurant_contact(restaurant.getRestaurant_contact());
//			restaurant.setRestaurant_address(restaurant.getRestaurant_address());
//			restaurant.setMenuList(restaurant.getMenuList());
//			restaurant.setUser(restaurant.getUser());
//	        return rRepo.save(restaurant);
//		}
		
//        Optional<Restaurants> billAdd = rRepo.findById(restaurant.getRestaurant_id());
//		
//		if(billAdd.isPresent()) {
//			Restaurants updatedRestaurants = billAdd.get();
//			updatedRestaurants.setRestaurant_name(restaurant.getRestaurant_name());
//			updatedRestaurants.setRestaurant_contact(restaurant.getRestaurant_contact());
//			updatedRestaurants.setRestaurant_address(restaurant.getRestaurant_address());
//			updatedRestaurants.setMenuList(restaurant.getMenuList());
//			updatedRestaurants.setUser(restaurant.getUser());
//			
//			return rRepo.save(updatedRestaurants);
//			
//		}else {
//			throw new RestaurantException("No such Restaurant exists..");
//		}
	


	public Restaurants updateRestaurant(Integer restaurant_id, Restaurants restaurant) throws RestaurantException {
		Optional<Restaurants> billUpdate = rRepo.findById(restaurant_id);
		
		if(billUpdate.isPresent()) {
			Restaurants updatedRestaurants = billUpdate.get();
			updatedRestaurants.setRestaurant_name(restaurant.getRestaurant_name());
			updatedRestaurants.setRestaurant_contact(restaurant.getRestaurant_contact());
			updatedRestaurants.setRestaurant_address(restaurant.getRestaurant_address());
			updatedRestaurants.setMenuList(restaurant.getMenuList());
			
			return rRepo.save(updatedRestaurants);
			
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


	@Override
	public Restaurants viewRestaurantByName(String restaurant_name) throws RestaurantException {
		Restaurants restaurant = rRepo.findByRestaurantname(restaurant_name) ;
		if(restaurant==null) {
			throw new RestaurantException("Restaurant "+ restaurant_name+ " Not Found");
		}else {
			return restaurant;
			
		}
		 
	}


	
//	public Menu deleteByDishName(String dish_name, Integer restaurant_id) throws MenuException {
//		Menu menu= menuRepo.findByDishNameAndRestaurantId(dish_name, restaurant_id);
//		Optional<Restaurants> restaurant = rRepo.findById(restaurant_id);
//		if(menu!=null && restaurant.isPresent()) {
//			menuRepo.delete(menu);
//			return menu;
//		}else {
//			throw new MenuException("Dish does not exist for the specified restaurant");
//		}
//		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	 public Restaurants validateRestaurant(String manager_name, String manager_password) throws RestaurantException{
//		 Optional<Restaurants> restOptional = rRepo.findByManager_name(manager_name);
//		 if(restOptional.isPresent()) {
//			 Restaurants restaurant = restOptional.get();
//			 if(restaurant.getManager_password().equals(manager_password)) {
//				 return restaurant;
//			 }else {
//				 throw new RestaurantException("Invalid Password");
//			 }
//		 }else {
//			 throw new RestaurantException("Manager Not Found");
//		 }
//	 }


