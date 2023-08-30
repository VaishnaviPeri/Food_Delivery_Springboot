package com.nexturn.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.OrderDetailsException;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.OrderDetails;
import com.nexturn.demo.Service.OrderDetailsService;

@RestController
@RequestMapping("/order")
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsService odservice;
	
	 @PostMapping("/save")
     public ResponseEntity<OrderDetails> saveOrder(@RequestBody OrderDetails order) throws OrderDetailsException{
     		return new ResponseEntity<OrderDetails>(odservice.addOrder(order), HttpStatus.CREATED);
     
       }
	 
	 
	 @PutMapping("/update")
     public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails order) throws OrderDetailsException{
     		return new ResponseEntity<OrderDetails>(odservice.updateOrder(order), HttpStatus.ACCEPTED);
     	
       }
	 
	 
	 @DeleteMapping("/remove/{order_id}")
     public ResponseEntity<OrderDetails> deleteOrder(@PathVariable Integer order_id) throws OrderDetailsException{
     		return new ResponseEntity<OrderDetails>(odservice.removeOrder(order_id), HttpStatus.ACCEPTED);
     	
	 }
	 
	
	 @GetMapping("/view/{order_id}")
     public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") Integer orderId) throws OrderDetailsException{
     		return  new ResponseEntity<OrderDetails>(odservice.viewOrder(orderId),HttpStatus.FOUND);
     	
     }
	 
	 
	 @GetMapping("/viewbycustomer/{customer_id}")
     public ResponseEntity<List<Menu>> viewAllOrders(@PathVariable Integer customer_id) throws OrderDetailsException, CustomerException{
     		return  new ResponseEntity<List<Menu>>(odservice.viewAllOdersByCustomer(customer_id), HttpStatus.FOUND);
     	
     }












}
