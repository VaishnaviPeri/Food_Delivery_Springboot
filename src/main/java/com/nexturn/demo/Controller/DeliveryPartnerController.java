package com.nexturn.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.nexturn.demo.ExceptionHandling.DeliveryPartnerNotFoundException;
import com.nexturn.demo.Model.DeliveryPartner;

import com.nexturn.demo.Model.User;
import com.nexturn.demo.Repository.DeliveryPartnerRepository;
import com.nexturn.demo.Repository.UserRepository;
import com.nexturn.demo.Service.DeliveryPartnerService;
import com.nexturn.demo.dto.DeliveryPartnerDto;
import com.nexturn.demo.dto.ResponseDto;


@RestController
@RequestMapping("/deliverypartner")
@CrossOrigin(origins="*")
public class DeliveryPartnerController {
	
	@Autowired
	DeliveryPartnerService dpservice;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	DeliveryPartnerRepository dpRepo;
	
	@Autowired
	ResponseDto responseDto;
	
	
	//saving user and deliverypartner info
	@PostMapping("/register")
	public ResponseEntity<Object> addDeliveryPartner(@RequestBody DeliveryPartnerDto dpDto){
		User user = new User();
		user.setUsername(dpDto.getUsername());
		user.setPassword(dpDto.getPassword());
		user.setRole("Delivery Partner");
		String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodePassword);
		user = userRepo.save(user);
		
		DeliveryPartner dp = new DeliveryPartner();
		dp.setDeliveryPartnerName(dpDto.getDeliveryPartnerName());
		dp.setDeliveryPartnerEmail(dpDto.getDeliveryPartnerEmail());
		dp.setDeliveryPartnerContact(dpDto.getDeliveryPartnerContact());

		
		dp.setUser(user);

		dpRepo.save(dp);
		responseDto.setMessage("delivery partner registered successfully");
		return ResponseEntity.status(HttpStatus.OK).body(responseDto);
	}
	
	// viewing delivery partner by id
	@GetMapping("/view/{id}")
	public ResponseEntity<DeliveryPartner> viewDeliveryPartner(@PathVariable Integer id) throws DeliveryPartnerNotFoundException{
		DeliveryPartner dp = dpservice.viewDeliveryPartner(id);
		return new ResponseEntity<DeliveryPartner>(dp, HttpStatus.FOUND);
	}
	
	
	// updating the details by id
	@PutMapping("update/{id}")
	public ResponseEntity<DeliveryPartner> updateDeliveryPartner(@PathVariable Integer id, @RequestBody DeliveryPartner dpartner) throws DeliveryPartnerNotFoundException{
		DeliveryPartner dp= dpservice.updateDeliveryPartner(id, dpartner);
		return new ResponseEntity<DeliveryPartner>(dp, HttpStatus.ACCEPTED);
	}
	
	//deleting the info
	@DeleteMapping("remove/{id}")
	public ResponseEntity<DeliveryPartner> removeDeliveryPartner(@PathVariable Integer id) throws DeliveryPartnerNotFoundException{
		DeliveryPartner dp= dpservice.removeDeliveryPartner(id);
		return new ResponseEntity<DeliveryPartner>(dp, HttpStatus.OK);
	}

}
