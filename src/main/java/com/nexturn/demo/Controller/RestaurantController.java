package com.nexturn.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.Restaurants;
import com.nexturn.demo.Service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	
	@Autowired
	RestaurantService rservice;
	
	@PostMapping("/add")
     public ResponseEntity<Restaurants> saveResturant( @RequestBody Restaurants restaurant) throws RestaurantException {		
		Restaurants newRestaurant = rservice.addRestaurant(restaurant);		
		return new ResponseEntity<Restaurants>(newRestaurant ,HttpStatus.CREATED);
	}
	

	@PutMapping("/update")
	public ResponseEntity<Restaurants> updateResturant(@RequestBody Restaurants restaurant) throws RestaurantException{		
		Restaurants updatedResturant=rservice.updateRestaurant(restaurant);		
		return new ResponseEntity<Restaurants>(updatedResturant,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{restaurant_id}")
	public ResponseEntity<Restaurants> getByResturantId(@PathVariable  Integer restaurant_id ) throws RestaurantException{
    			Restaurants restaurant =rservice.viewRestaurant(restaurant_id);	
    			return new ResponseEntity<Restaurants>(restaurant ,HttpStatus.ACCEPTED);   	
    	
	}
	
	
	@DeleteMapping("/remove/{restaurantId}")
	public ResponseEntity<Restaurants> deleteRestaurant(@PathVariable("restaurantId") Integer restaurantId) throws RestaurantException{
		Restaurants removedRestaurant = rservice.removeRestauarant(restaurantId);
		return new ResponseEntity<Restaurants>(removedRestaurant, HttpStatus.OK);
	}
	
}
