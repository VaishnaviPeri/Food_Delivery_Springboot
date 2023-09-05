package com.nexturn.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.BillException;

import com.nexturn.demo.ExceptionHandling.DeliveryPartnerNotFoundException;
import com.nexturn.demo.Model.Bill;
import com.nexturn.demo.Model.DeliveryPartner;
import com.nexturn.demo.Model.DeliveryPartner;
import com.nexturn.demo.Model.User;
import com.nexturn.demo.Repository.DeliveryPartnerRepository;
import com.nexturn.demo.Repository.UserRepository;


@Service
public class DeliveryPartnerService {
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	@Autowired
//	private UserRepository userRepository;
	@Autowired
	private DeliveryPartnerRepository dpr;
	
	
	
	
	
	// add delivery Partner
		
		public DeliveryPartner addDeliveryPartner(DeliveryPartner delpartner) throws DeliveryPartnerNotFoundException {
			Optional<DeliveryPartner> dp= dpr.findById(delpartner.getId());
			if(dp.isPresent()) {
				throw new DeliveryPartnerNotFoundException("DeliveryPartner already exists");	
			}else {
				return dpr.save(delpartner);
			}
		}
		
		
		public DeliveryPartner removeDeliveryPartner(Integer id) throws DeliveryPartnerNotFoundException {
			Optional<DeliveryPartner> dp= dpr.findById(id);
			if(dp.isPresent()) {
				DeliveryPartner dp_1= dp.get();
				dpr.delete(dp_1);
				return dp_1;
				
			}else {
				throw new DeliveryPartnerNotFoundException("Delivery Partner not found with ID "+ id);
			}
		}
		
		
		public DeliveryPartner updateDeliveryPartner(Integer id, DeliveryPartner delpartner) throws DeliveryPartnerNotFoundException {
			Optional<DeliveryPartner> dpUpdate= dpr.findById(id);
			if(dpUpdate.isPresent()) {
				DeliveryPartner updatedDelPartner = dpUpdate.get();
				updatedDelPartner.setDeliveryPartnerName(delpartner.getDeliveryPartnerName());
				updatedDelPartner.setDeliveryPartnerEmail(delpartner.getDeliveryPartnerEmail());
				updatedDelPartner.setDeliveryPartnerContact(delpartner.getDeliveryPartnerContact());
				updatedDelPartner.setUser(delpartner.getUser());
			
				return dpr.save(updatedDelPartner);
			}
			else {
			   throw new DeliveryPartnerNotFoundException("Delivery Partner with Id "+ delpartner.getId() +" is not found");
		}
	}
		
		
		public DeliveryPartner viewDeliveryPartner(Integer id) throws DeliveryPartnerNotFoundException {
			Optional<DeliveryPartner> dp = dpr.findById(id);
			if(dp.isPresent()) {
				DeliveryPartner DeliveryPartner = dp.get();
				return DeliveryPartner;
			}else {
				throw new DeliveryPartnerNotFoundException("No DeliveryPartner found with ID: "+id);
			}
		}

}
