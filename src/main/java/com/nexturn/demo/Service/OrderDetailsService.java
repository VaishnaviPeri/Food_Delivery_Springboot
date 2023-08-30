package com.nexturn.demo.Service;

import java.util.List;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.OrderDetailsException;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.OrderDetails;

public interface OrderDetailsService {
	
	public OrderDetails addOrder(OrderDetails orderDetails) throws OrderDetailsException;
	
	public OrderDetails removeOrder(Integer order_id) throws OrderDetailsException;
	
	public OrderDetails updateOrder(OrderDetails orderDetails) throws OrderDetailsException;
	
	public OrderDetails viewOrder(Integer order_id) throws OrderDetailsException;
	
	public List<Menu> viewAllOdersByCustomer(Integer customer_id) throws CustomerException, OrderDetailsException;
	

}
