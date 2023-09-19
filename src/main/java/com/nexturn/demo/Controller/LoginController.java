package com.nexturn.demo.Controller;




import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.ExceptionHandling.UsernameNotFoundException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.DeliveryPartner;
import com.nexturn.demo.Model.Restaurants;
import com.nexturn.demo.Model.User;
import com.nexturn.demo.Repository.CustomerRepository;
import com.nexturn.demo.Repository.DeliveryPartnerRepository;
import com.nexturn.demo.Repository.RestaurantRepository;
import com.nexturn.demo.Repository.UserRepository;
import com.nexturn.demo.dto.CustomerDto;
import com.nexturn.demo.dto.DeliveryPartnerDto;
import com.nexturn.demo.dto.ResponseDto;
import com.nexturn.demo.dto.RestaurantDto;

@RestController
@RequestMapping("/user")
public class LoginController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CustomerRepository custRepo;
	@Autowired
	private RestaurantRepository restRepo;
	@Autowired
	private DeliveryPartnerRepository delpartRepo;
	
	
	@Autowired
	private ResponseDto responseDto;
	@Autowired
	private CustomerDto customerDto;
	@Autowired
	private RestaurantDto restaurantDto;
	@Autowired
	private DeliveryPartnerDto delpartDto;
	
	
	
	@PostMapping("/login")
	public Object userLogin(Principal principal) throws UsernameNotFoundException{ //The principal is the currently logged in use
		System.out.println(principal);
	     String username = principal.getName();
//	     System.out.println(username);
	     System.out.println(principal.getName());
		User user = userRepo.findByUsername(username);
//		System.out.println(user);
		if(user == null) {
			responseDto.setMessage("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
 		}
		user.setPassword("Hidden");
		return user;
	}

	//	catch(Exception e) {
//		throw new UsernameNotFoundException("User not found  !!!!", e);
		
	
//	@GetMapping("/login")
//	 public User userLogin(String username, String password){	
//		    // Access the Principal object safely here	
//		return userRepo.findByUsernameAndPassword(username, password);	
//		
//	}
	
		
		@GetMapping("/get/details")
		public Object getUserDetails(Principal principal) throws UsernameNotFoundException, RestaurantException {
			String username = principal.getName();
			User user = userRepo.findByUsername(username);
			if(user == null) {
				responseDto.setMessage("Invalid Credentials");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
	 		}
			if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
				Customer customer = custRepo.findACustomerDetails(username);
				customerDto.setCustomer_id(customer.getCustomer_id());
				customerDto.setCustomer_name(customer.getCustomer_name());
				customerDto.setUsername(customer.getUser().getUsername());
				customerDto.setPassword(customer.getUser().getPassword());
				customerDto.setCustomer_emailId(customer.getCustomer_emailId());
				customerDto.setCustomer_phone_no(customer.getCustomer_phone_no());
				customerDto.setAddress(customer.getAddress());
				customerDto.setCity(customer.getCity());
				customerDto.setState(customer.getState());
				customerDto.setZipcode(customer.getZipcode());

				return customerDto;
			}
			
			if(user.getRole().equalsIgnoreCase("RESTAURANTS")) {
				Restaurants restaurant = restRepo.findRestaurantDetails(username);
				restaurantDto.setRestaurant_id(restaurant.getRestaurant_id());
				restaurantDto.setRestaurant_contact(restaurant.getRestaurant_contact());
				restaurantDto.setRestaurant_name(restaurant.getRestaurant_name());
				restaurantDto.setUsername(restaurant.getUser().getUsername());
				restaurantDto.setPassword(restaurant.getUser().getPassword());
				
				return restaurantDto;
			}
			
			if(user.getRole().equalsIgnoreCase("DELIVERYPARTNER")) {
				DeliveryPartner deliverypartner = delpartRepo.findDeliveryPartnerDetails(username);
				deliverypartner.setId(deliverypartner.getId());
				delpartDto.setDeliveryPartnerName(deliverypartner.getDeliveryPartnerName());
				delpartDto.setDeliveryPartnerEmail(deliverypartner.getDeliveryPartnerEmail());
				delpartDto.setDeliveryPartnerContact(deliverypartner.getDeliveryPartnerContact());
				delpartDto.setUsername(deliverypartner.getUser().getUsername());
				delpartDto.setPassword(deliverypartner.getUser().getPassword());
				
				return delpartDto;
			}
			return null;
	}
}
	
	

//	    @Autowired
//	    private AuthenticationManager authenticationManager;
//
//	    @PostMapping("/login")
//	    public ResponseEntity<Object> login(@RequestBody User user) {
//
//	        // Authenticate the user
//	        Authentication authentication = authenticationManager.authenticate(
//	                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
//
//	        // Get the user from the database
//	        User userdetails = userRepo.findByUsername(user.getUsername());
//
//	        // If the user does not exist, return an error message
//	        if (userdetails == null) {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//	        }
//
//	        // If the password does not match, return an error message
//	        if (!userdetails.getPassword().equals(user.getPassword())) {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//	        }
//
//	        // Set the user's authentication in the security context
//	        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//	        // If the user is a customer, return the customer details
//	        if (userdetails.getRole().equalsIgnoreCase("CUSTOMER")) {
//	            Customer customer = custRepo.findByUser(userdetails);
//	            return ResponseEntity.status(HttpStatus.OK).body(customer);
//	        }
//
//	        // If the user is a restaurant, return the restaurant details
//	        if (user.getRole().equalsIgnoreCase("RESTAURANT")) {
//	            Restaurants restaurant = restRepo.findByUser(userdetails);
//	            return ResponseEntity.status(HttpStatus.OK).body(restaurant);
//	        }
//
//	        // If the user is not a customer or restaurant, return an error message
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
//	    }
//	}


