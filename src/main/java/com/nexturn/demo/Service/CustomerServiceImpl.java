package com.nexturn.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepo;
	
	
	
     //add customer
//	public Customer addCustomer(Customer customer) throws CustomerException {
//		Optional<Customer> cust= customerRepo.findById(customer.getCustomer_id());
//		if(!cust.isPresent()) {
//			
//			return customerRepo.save(customer);
//			
//		}else {
//			throw new CustomerException("Customer already exists");	
//		}
//	}
//	

	//remove customer based on id
	public Customer removeCustomer(Integer customer_id) throws CustomerException {
		Optional<Customer> cust= customerRepo.findById(customer_id);
		if(cust.isPresent()) {
			Customer cust_1= cust.get();
			customerRepo.delete(cust_1);
			return cust_1;
			
		}else {
			throw new CustomerException("customer not found with ID "+ customer_id);
		}

	}


//	public Customer updatecustomer(Customer customer) throws CustomerException {
//		Optional<Customer> opt = customerRepo.findById(customer.getCustomer_id());
//		if(opt.isPresent()) {
//			return customerRepo.save(customer);
//		}else {
//			throw new CustomerException("No such customer exists..");
//		}
//	
//	}
	
	//update customer
	public Customer updateCustomer(Integer customer_id, Customer customer) throws CustomerException {
		Optional<Customer> cust= customerRepo.findById(customer_id);
		if(cust.isPresent()) {
			Customer updatedCustomer = cust.get();
			updatedCustomer.setCustomer_name(customer.getCustomer_name());
			updatedCustomer.setCustomer_emailId(customer.getCustomer_emailId());
			updatedCustomer.setCustomer_phone_no(customer.getCustomer_phone_no());
			updatedCustomer.setCustomer_gender(customer.getCustomer_gender());
			updatedCustomer.setAddress(customer.getAddress());
			updatedCustomer.setCity(customer.getCity());
			updatedCustomer.setState(customer.getState());
			updatedCustomer.setZipcode(customer.getZipcode());
//			updatedCustomer.setFoodCart(customer.getFoodCart());
		
			return customerRepo.save(updatedCustomer);
		}
		else {
		   throw new CustomerException("Customer with Id "+ customer.getCustomer_id() +" is not found");
	}
}

  //view customer by id
	public Customer viewCustomer(Integer customer_id) throws CustomerException {
		Optional<Customer> opt = customerRepo.findById(customer_id);
		if(opt.isPresent()) {
			Customer customer = opt.get();
			return customer;
		}else {
			throw new CustomerException("No Customer found with ID: "+customer_id);
		}
	}



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	public Customer viewCustomer(Customer customer) throws CustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}


//	 public Customer validateCustomer(String customer_name, String customer_password) throws CustomerException{
//		 Optional<Customer> customerOptional = customerRepo.findByCustomerName(customer_name);
//		 if(customerOptional.isPresent()) {
//			 Customer customer = customerOptional.get();
//			 if(customer.getCustomer_password().equals(customer_password)) {
//				 return customer;
//			 }else {
//				 throw new CustomerException("Invalid Password");
//			 }
//		 }else {
//			 throw new CustomerException("User Not Found");
//		 }
//	 }
	 
//	 public Customer findByCustomerName(String customer_name) throws CustomerException {
//			// TODO Auto-generated method stub
//			Optional<Customer> customer = customerRepo.findByCustomerName(customer_name);
//			if(customer == null) {
//				throw new UsernameNotFoundException("Invalid user credentials");
//			}
//			SimpleGrantedAuthority sga = new SimpleGrantedAuthority(customer.get());
//			List<SimpleGrantedAuthority> list = new ArrayList<>();
//			list.add(sga);
//			return new Customer(customer.getCustomer_name(), customer.getCustomer_password(), list);
//		}
	
	
 

}
