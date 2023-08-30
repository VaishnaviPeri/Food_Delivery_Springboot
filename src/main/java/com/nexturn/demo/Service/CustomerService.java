package com.nexturn.demo.Service;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.Model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Integer customer_id) throws CustomerException;
	
	public Customer updatecustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Customer customer) throws CustomerException;

	Customer viewCustomer(Integer customer_id) throws CustomerException;
	

}
