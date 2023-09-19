package com.nexturn.demo.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.BillException;
import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Bill;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Repository.BillRepository;
import com.nexturn.demo.Repository.CustomerRepository;
import com.nexturn.demo.Repository.FoodCartRepository;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillRepository billRepo;
	
	@Autowired
	CustomerRepository customerRepo;
	
	private Bill bill;
	
	private FoodCart foodCart;
	
	@Autowired
	FoodCartRepository fcRepo;
	
	
	
	
	public Bill generateBill(Integer cart_id) throws BillException {
	    // Retrieve all items in the foodcart for the specified cart_id
	   try {
		List<FoodCart> itemsInCart = fcRepo.findByCartId(cart_id);	    
	    if (itemsInCart.isEmpty()) {
	        throw new BillException("No items found in the foodcart. Try again ....!");
	    }

	    double billTotal = 0.0;

	    // Calculate the total bill by summing the prices of all items
	    for (FoodCart item : itemsInCart) {
	        // Retrieve the menu item's price using the menu_id
	        Menu menu = item.getMenu();
	        
	        if (menu != null) {
	            double pricePerItem = menu.getDish_price();
	            int itemQuantity = item.getItem_quantity();
	            double itemTotal = pricePerItem * itemQuantity;
	            
	            // Add the item's total to the overall total bill
	            billTotal += itemTotal;
	        }
	    } 

	    Bill bill = new Bill();
	    bill.setBill_date(LocalDateTime.now());
	    bill.setBill_total(billTotal);
	    bill.setQuantity(itemsInCart.size()); // Set the total number of items in the bill
	    bill.setFoodCart(itemsInCart.get(0)); // Assuming you set one FoodCart as a representative in the Bill

	    billRepo.save(bill);
	   }
	   catch (FoodCartException e) {
			e.printStackTrace();
		}
	    return bill;

	}
}




//public Bill createBill(Integer cart_id) throws BillException {
//  
//	Optional<FoodCart> optionalfoodCart = fcRepo.findById(cart_id);
//	 FoodCart foodCart = optionalfoodCart.orElseThrow(() -> new BillException("Foodcart id is not found. Try again ....!"));
////	if(foodCart==null) {
////			throw new BillException("Foodcart id is not found. Try again ....!");
////	}
//	
//	double billTotal= CalculateBillTotal(foodCart);
//	
//	Bill bill = new Bill();
//	bill.setBill_date(LocalDateTime.now());
//	bill.setBill_total(billTotal);
//	bill.setQuantity(foodCart.getItem_quantity());
//	bill.setFoodCart(foodCart);
//	
//	billRepo.save(bill);
//	return bill;
//
//}
//
//private double CalculateBillTotal(FoodCart foodCart) {	
//double pricePerItem = foodCart.getMenu().getDish_price();
//int itemQuantity = foodCart.getItem_quantity();
//return pricePerItem*itemQuantity;
//}
	
	
	
	
	
	
//	public Bill createBill(Integer bill_id) throws BillException {
//		Optional<Bill> bill_1= billRepo.findById(bill.getBill_id());
//		if(bill_1.isPresent()) {
//			throw new BillException("bill already exists");
//		}else {
//			return billRepo.save(bill);
//		}		
//	}

	
//	public Bill removeBill(Integer bill_id) throws BillException {
//		Optional<Bill> bill_2= billRepo.findById(bill_id);
//		if(bill_2.isPresent()) {
//			Bill bill= bill_2.get();
//			billRepo.delete(bill);
//			return bill;
//		}else {
//		      throw new BillException("Bill does not exist with will Id "+ bill_id);
//		}
//		
//	}
//
//	public Bill updateBill(Integer bill_id, Bill bill) throws BillException {
//        Optional<Bill> billUpdate= billRepo.findById(bill_id);
//		if(billUpdate.isPresent()) {
//			Bill updatedBill = billUpdate.get();
//			updatedBill.setBill_date(bill.getBill_date());
//			updatedBill.setQuantity(bill.getQuantity());
//			updatedBill.setBill_total(bill.getBill_total());
//			
//			return billRepo.save(updatedBill);
//		}
//		else {
//		   throw new BillException("Bill is not found");
//	}
//}
//
//	@Override
//	public Bill viewBill(Integer bill_id) throws BillException {
//		Optional<Bill> bills= billRepo.findById(bill_id);
//		if(bills.isPresent()) {
//			return bills.get();
//		}else {
//			throw new BillException("Bill not found");
//		}
//	}

//	@Override
//	public double totalBillById(Integer customer_id) throws MenuException, CustomerException {
//		
//		Optional<Customer> cOpt = customerRepo.findById(customer_id);
//		if(cOpt.isPresent()) {
//			Customer customer = cOpt.get();
//			List<Menu> items = customer.getFoodCart().getMenuList();	
//			if(items.size() > 0) {			
//				Double total = 0.0;
//				for(Menu item : items) {
//					total += (item.getDish_price()*item.getQuantity()); 
//				}
//				
//				return total;
//				
//			}else {
//				throw new MenuException("No order items found for "+ customer.getCustomer_name());
//			}
//			
//		}else {
//			throw new CustomerException("No Customer found with ID: "+ customer_id);
//		}
//	}
	
	
//	updatedBill.setBill_date(bill.getBill_date());
//	updatedBill.setQuantity(bill.getBill_id());
//	updatedBill.setBill_total(bill.getBill_total());


