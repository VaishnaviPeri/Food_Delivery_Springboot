package com.nexturn.demo.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CustomerRepository cusRepo;
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
	public Object userLogin(Principal principal) throws UsernameNotFoundException { //The principal is the currently logged in use
		try {
		String username = principal.getName();
		User user = userRepo.findByUsername(username);
		if(user == null) {
			responseDto.setMessage("Invalid Credentials");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
 		}
		user.setPassword("Hidden");
		return user;
	}catch(Exception e) {
		throw new UsernameNotFoundException("User not found  !!!!", e);
	}
}
		
		@GetMapping("/get/details")
		public Object getUserDetails(Principal principal) throws UsernameNotFoundException {
			String username = principal.getName();
			User user = userRepo.findByUsername(username);
			if(user == null) {
				responseDto.setMessage("Invalid Credentials");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseDto);
	 		}
			if(user.getRole().equalsIgnoreCase("CUSTOMER")) {
				Customer customer = cusRepo.findACustomerDetails(username);
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
