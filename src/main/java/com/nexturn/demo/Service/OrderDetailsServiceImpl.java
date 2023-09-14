package com.nexturn.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.DeliveryPartnerNotFoundException;
import com.nexturn.demo.ExceptionHandling.OrderDetailsException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.DeliveryPartner;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.OrderDetails;
import com.nexturn.demo.Repository.CustomerRepository;
import com.nexturn.demo.Repository.OrderDetailsRepository;


@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
	
	@Autowired
	OrderDetailsRepository odRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	private OrderDetails orderdetails;

	
	public OrderDetails addOrder(OrderDetails orderDetails) throws OrderDetailsException {
		Optional<OrderDetails> opt = odRepo.findById(orderDetails.getOrder_id());
		if(opt.isPresent()) {
			throw new OrderDetailsException("Order Id already exists");
		}else {
			
			return odRepo.save(orderDetails);
		}
		
	}

	
	public OrderDetails removeOrder(Integer order_id) throws OrderDetailsException {
		Optional<OrderDetails> opt = odRepo.findById(order_id);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			odRepo.delete(order);
			return order;
		}else {
			throw new OrderDetailsException("No Order found with ID: "+order_id);
		}
	}

	
	public OrderDetails updateOrderDetails(Integer order_id, OrderDetails orderdetails) throws OrderDetailsException {
		Optional<OrderDetails> UpdateOD= odRepo.findById(order_id);
		
		if(UpdateOD.isPresent()) {
			OrderDetails updatedOD = UpdateOD.get();
			updatedOD.setOrder_status(orderdetails.getOrder_status());
			updatedOD.setOrder_date(orderdetails.getOrder_date());
			updatedOD.setBill(orderdetails.getBill());
			updatedOD.setCart(orderdetails.getCart());
		
			return odRepo.save(updatedOD);
		}
		else {
		   throw new OrderDetailsException("Order Details with Id "+ orderdetails.getOrder_id() +" is not found");
	}
}

	
	public OrderDetails viewOrder(Integer order_id) throws OrderDetailsException {
		Optional<OrderDetails> opt = odRepo.findById(order_id);
		if(opt.isPresent()) {
			OrderDetails order = opt.get();
			return order;
		}else {
			throw new OrderDetailsException("No Order found with ID: "+order_id);
		}
	}

//	public List<Menu> viewAllOdersByCustomer(Integer customer_id) throws CustomerException, OrderDetailsException {
//		Optional<Customer> cOpt =customerRepo.findById(customer_id);
//		if(cOpt.isPresent()) {
//			Customer customer = cOpt.get();
//			 Menu itemList = customer.getFoodCart().getMenu();
//			 if(itemList.size() > 0) {
//				 return itemList;
//			 }else {
//				 throw new OrderDetailsException("No Orders found..");
//			 }
//		}else {
//			throw new CustomerException("No Customer found with ID: "+customer_id);
//		}
//	}


//	public OrderDetails updateOrder(OrderDetails orderDetails) throws OrderDetailsException {
//	Optional<OrderDetails> opt = odRepo.findById(orderDetails.getOrder_id());
//	if(opt.isPresent()) {
//		return odRepo.save(orderDetails);
//	}else {
//		throw new OrderDetailsException("Order such Order exists..");
//	}
//}
	
	

}
