package com.nexturn.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Restaurants;
import com.nexturn.demo.Security.JWTConfig;
import com.nexturn.demo.Service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	
	@Autowired
	RestaurantService rservice;
	
//	@Autowired
//	JWTConfig jwtConfig;
	
	@PostMapping("/add")
     public ResponseEntity<Restaurants> saveResturant( @RequestBody Restaurants restaurant) throws RestaurantException {		
		Restaurants newRestaurant = rservice.addRestaurant(restaurant);		
		return new ResponseEntity<Restaurants>(newRestaurant ,HttpStatus.CREATED);
	}
	

	@PutMapping("/update/{restaurant_id}")
	public ResponseEntity<Restaurants> updateResturant(@PathVariable Integer restaurant_id, @RequestBody Restaurants restaurant) throws RestaurantException{		
		Restaurants updatedResturant=rservice.updateRestaurant(restaurant_id,restaurant);		
		return new ResponseEntity<Restaurants>(updatedResturant,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{restaurant_id}")
	public ResponseEntity<Restaurants> getByResturantId(@PathVariable  Integer restaurant_id ) throws RestaurantException{
    			Restaurants restaurant =rservice.viewRestaurant(restaurant_id);	
    			return new ResponseEntity<Restaurants>(restaurant ,HttpStatus.OK);   	
    	
	}
	
	@GetMapping("/viewbyname/{restaurant_name}")
	public ResponseEntity<Restaurants> getByRestaurantName(@PathVariable String restaurant_name) throws RestaurantException{
		try {
		Restaurants restaurant = rservice.viewRestaurantByName(restaurant_name);
		return new ResponseEntity<>(restaurant, HttpStatus.FOUND);
	}catch(Exception ex) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
	
	
	@DeleteMapping("/remove/{restaurantId}")
	public ResponseEntity<Restaurants> deleteRestaurant(@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
		Restaurants removedRestaurant = rservice.removeRestauarant(restaurantId);
		return new ResponseEntity<Restaurants>(removedRestaurant, HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> restaurantRegistration(@RequestBody Restaurants restaurant) throws RestaurantException{
		try {
			rservice.addRestaurant(restaurant);
			return new ResponseEntity<>("Registration Successfull...!",HttpStatus.CREATED);
		}catch(RestaurantException re) {
			return new ResponseEntity<>("Registration failed..!",HttpStatus.BAD_REQUEST);
		}
	}
	
//	@PostMapping("/login")
//	public ResponseEntity<String> managerLogin(@RequestBody Restaurants loginCredentials){
//		try {
//			Restaurants restaurant= rservice.validateRestaurant(loginCredentials.getManager_name(),loginCredentials.getManager_password());
//		    String token= jwtConfig.generateToken(restaurant.getManager_name());
//		    return new ResponseEntity<>(token, HttpStatus.OK);
//		}catch(RestaurantException ce){
//			return new ResponseEntity<>(ce.getMessage(),HttpStatus.UNAUTHORIZED);
//			
//		}
//	}
	
	
	
}
