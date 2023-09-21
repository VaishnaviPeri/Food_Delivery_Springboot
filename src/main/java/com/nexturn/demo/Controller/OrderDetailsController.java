package com.nexturn.demo.Controller;

import java.util.ArrayList;
import java.util.List;

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

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.OrderDetailsException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.OrderDetails;
import com.nexturn.demo.Service.FoodCartService;
import com.nexturn.demo.Service.OrderDetailsService;
import com.nexturn.demo.dto.CustomerDto;
import com.nexturn.demo.dto.OrderDetailsWithCustomer;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins="*")
public class OrderDetailsController {
	
	@Autowired
	OrderDetailsService odservice;
	@Autowired
	FoodCartService fcService;
	
	 @PostMapping("/create")
     public ResponseEntity<OrderDetails> createOrderDetails(@RequestBody OrderDetails order) throws OrderDetailsException{
     		return new ResponseEntity<OrderDetails>(odservice.createOrder(order), HttpStatus.CREATED);
     
       }
	 
	 
	 @PutMapping("/update/{order_id}")
     public ResponseEntity<OrderDetails> updateOrder(@PathVariable Integer order_id, @RequestBody OrderDetails odetails) throws OrderDetailsException{
     		return new ResponseEntity<OrderDetails>(odservice.updateOrderDetails(order_id,odetails), HttpStatus.ACCEPTED);
     	
       }
	 
	 
	 @DeleteMapping("/remove/{order_id}")
     public ResponseEntity<OrderDetails> deleteOrder(@PathVariable Integer order_id) throws OrderDetailsException{
     		return new ResponseEntity<OrderDetails>(odservice.removeOrder(order_id), HttpStatus.ACCEPTED);
     	
	 }
	 
	
//	 @GetMapping("/view/{order_id}")
//     public ResponseEntity<OrderDetails> viewOrder(@PathVariable Integer order_id) throws OrderDetailsException{
//     		return  new ResponseEntity<OrderDetails>(odservice.viewOrder(order_id),HttpStatus.FOUND);
//     	
//     }
	 
	 
	 @GetMapping("/vieworder/{order_id}")
	 public ResponseEntity<List<OrderDetailsWithCustomer>> viewOrderByOrderId(@PathVariable("order_id") Integer order_id) throws OrderDetailsException, FoodCartException {
	     // Retrieve OrderDetails by order_id
	     OrderDetails orderDetails = odservice.viewOrder(order_id);
	     
	     if (orderDetails == null) {
	         return ResponseEntity.notFound().build();
	     }

	     // Retrieve FoodCart items associated with the order
	     List<FoodCart> foodCarts = fcService.viewCart(order_id);

	     // Create a list of responses
	     List<OrderDetailsWithCustomer> responses = new ArrayList<>();

	   
	     for (FoodCart foodCart : foodCarts) {
	         OrderDetailsWithCustomer response = new OrderDetailsWithCustomer();
	         response.setOrderDetails(orderDetails);
	         response.setMenu(foodCart.getMenu());
	         response.setCustomer(mapCustomerToDTO(foodCart.getCustomer()));
	         
	         // Add the response to the list
	         responses.add(response);
	     }

	  
	     return ResponseEntity.ok(responses); 
	 }


          private CustomerDto mapCustomerToDTO(Customer customer) {
        	  CustomerDto customerDTO = new CustomerDto();
        	    customerDTO.setCustomer_id(customer.getCustomer_id());
        	    customerDTO.setCustomer_name(customer.getCustomer_name());
        	    customerDTO.setCustomer_phone_no(customer.getCustomer_phone_no());
        	    customerDTO.setAddress(customer.getAddress());
        	    customerDTO.setCity(customer.getCity());
        	    customerDTO.setState(customer.getState());
        	    customerDTO.setZipcode(customer.getZipcode());
        	    return customerDTO;
}

	 
	 
	 
//	 
//	 @GetMapping("/viewbycustomer/{customer_id}")
//     public ResponseEntity<List<Menu>> viewAllOrders(@PathVariable Integer customer_id) throws OrderDetailsException, CustomerException{
//     		return  new ResponseEntity<List<Menu>>(odservice.viewAllOdersByCustomer(customer_id), HttpStatus.FOUND);
//     	
//     }












}
