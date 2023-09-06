package com.nexturn.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.nexturn.demo.Service.DeliveryPartnerService;

@RestController
@RequestMapping("/deliverypartner")
@CrossOrigin("/*")
public class DeliveryPartnerController {
	
	@Autowired
	DeliveryPartnerService dpservice;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<DeliveryPartner> addDeliveryPartner(@RequestBody DeliveryPartner delpartner) throws DeliveryPartnerNotFoundException{
		try {
		
		DeliveryPartner dp = dpservice.addDeliveryPartner(delpartner);
		return new ResponseEntity<>(dp,HttpStatus.CREATED);
		}catch(DeliveryPartnerNotFoundException e){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<DeliveryPartner> viewDeliveryPartner(@PathVariable Integer id) throws DeliveryPartnerNotFoundException{
		DeliveryPartner dp = dpservice.viewDeliveryPartner(id);
		return new ResponseEntity<DeliveryPartner>(dp, HttpStatus.FOUND);
	}
	
	
	@PutMapping("update/{id}")
	public ResponseEntity<DeliveryPartner> updateDeliveryPartner(@PathVariable Integer id, @RequestBody DeliveryPartner dpartner) throws DeliveryPartnerNotFoundException{
		DeliveryPartner dp= dpservice.updateDeliveryPartner(id, dpartner);
		return new ResponseEntity<DeliveryPartner>(dp, HttpStatus.ACCEPTED);
	}
	
	
	@DeleteMapping("remove/{id}")
	public ResponseEntity<DeliveryPartner> removeDeliveryPartner(@PathVariable Integer id) throws DeliveryPartnerNotFoundException{
		DeliveryPartner dp= dpservice.removeDeliveryPartner(id);
		return new ResponseEntity<DeliveryPartner>(dp, HttpStatus.OK);
	}

}
