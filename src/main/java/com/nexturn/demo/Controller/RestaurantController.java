package com.nexturn.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.nexturn.demo.Model.User;
import com.nexturn.demo.Repository.RestaurantRepository;
import com.nexturn.demo.Repository.UserRepository;
import com.nexturn.demo.Security.JWTConfig;
import com.nexturn.demo.Service.RestaurantService;
import com.nexturn.demo.dto.ResponseDto;
import com.nexturn.demo.dto.RestaurantDto;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin(origins="*")
public class RestaurantController {

	
	@Autowired
	RestaurantService rservice;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	RestaurantRepository restRepo;
	
	@Autowired
	ResponseDto responseDto;
	
//	@Autowired
//	JWTConfig jwtConfig;
	
//	@PostMapping("/add")
//     public ResponseEntity<Restaurants> saveResturant( @RequestBody Restaurants restaurant) throws RestaurantException {		
//		Restaurants newRestaurant = rservice.addRestaurant(restaurant);		
//		return new ResponseEntity<Restaurants>(newRestaurant ,HttpStatus.CREATED);
//	}
	
	
	@PostMapping("/register")
	public ResponseEntity<Object> addRestaurant(@RequestBody RestaurantDto restaurantDto){
		User user = new User();
		user.setUsername(restaurantDto.getUsername());
		user.setPassword(restaurantDto.getPassword());
		user.setRole("Restaurant");
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		user = userRepo.save(user);
		
		Restaurants restaurant = new Restaurants();
		restaurant.setRestaurant_name(restaurantDto.getRestaurant_name());
		restaurant.setRestaurant_contact(restaurantDto.getRestaurant_contact());
		restaurant.setRestaurant_address(restaurantDto.getRestaurant_address());
//		restaurant.setMenuList(restaurant.getMenuList());
		
		restaurant.setUser(user);

		restRepo.save(restaurant);
		responseDto.setMessage("restaurant registered successfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
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
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
//	@PostMapping("/register")
//	public ResponseEntity<String> restaurantRegistration(@RequestBody Restaurants restaurant) throws RestaurantException{
//		try {
//			rservice.addRestaurant(restaurant);
//			return new ResponseEntity<>("Registration Successfull...!",HttpStatus.CREATED);
//		}catch(RestaurantException re) {
//			return new ResponseEntity<>("Registration failed..!",HttpStatus.BAD_REQUEST);
//		}
//	}
	
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
