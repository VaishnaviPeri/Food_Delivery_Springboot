package com.nexturn.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Repository.CustomerRepository;
import com.nexturn.demo.Security.JWTConfig;
import com.nexturn.demo.Service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService cservice;
	
	@Autowired
	CustomerRepository cRepo;



//	@Autowired
//	JWTConfig jwtConfig;

	@PostMapping("/add")
	public ResponseEntity<Customer> addcustomer(@RequestBody Customer customer) throws CustomerException {
		Customer cust = cservice.addCustomer(customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.CREATED);

	}

	@GetMapping("/view/{customer_id}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable int customer_id) throws CustomerException {
		Customer cust = cservice.viewCustomer(customer_id);
		return new ResponseEntity<Customer>(cust, HttpStatus.FOUND);
	}

	@PutMapping("/update/{customer_id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customer_id, @RequestBody Customer customer) throws CustomerException {
		Customer cust = cservice.updateCustomer(customer_id,customer);
		return new ResponseEntity<Customer>(cust, HttpStatus.ACCEPTED);

	}

	@DeleteMapping("/delete/{customer_id}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable int customer_id) throws CustomerException {
		Customer cust = cservice.removeCustomer(customer_id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	public AuthController(CustomerService cservice, JWTConfig jwtConfig) {
//        this.cservice = cservice;
//        this.jwtConfig = jwtConfig;
//    }

//	@PostMapping("/login")
//	public ResponseEntity<String> customerLogin(@RequestBody Customer customer){
//		try {
//			Customer customer= cservice.validateCustomer(loginCredentials.getCustomer_name(),loginCredentials.getCustomer_password());
//		    String token= jwtConfig.generateToken(customer.getCustomer_name());
//		    return new ResponseEntity<>(token, HttpStatus.OK);
//		}catch(CustomerException ce){
//			return new ResponseEntity<>(ce.getMessage(),HttpStatus.UNAUTHORIZED);
//		}
//	Customer customer1 = cRepo.findByCustomer_name(customer);
//	if(customer1==null)
//	{
//		throw new CustomerException("Invalid user credentials");
//	}
//	SimpleGrantedAuthority sga = new SimpleGrantedAuthority(customer.getCustomer_name());
//	List<SimpleGrantedAuthority> list = new ArrayList<>();list.add(sga);
//	return new org.springframework.security.core.userdetails.User(customer1.getCustomer_name(),customer1.getCustomer_password(),list);
//}
//}

	@PostMapping("/register")
	public ResponseEntity<String> customerRegistration(@RequestBody Customer customer) throws CustomerException {
		try {
			cservice.addCustomer(customer);
			return new ResponseEntity<>("Registration Successfull...!", HttpStatus.CREATED);
		} catch (CustomerException ce) {
			return new ResponseEntity<>("Registration failed..!", HttpStatus.BAD_REQUEST);
		}
	}

}