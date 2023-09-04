package com.nexturn.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.BillException;
import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Bill;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Repository.BillRepository;
import com.nexturn.demo.Repository.CustomerRepository;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillRepository billRepo;
	CustomerRepository customerRepo;
	private Bill bill;
	
	public Bill addBill(Bill bill) throws BillException {
		Optional<Bill> bill_1= billRepo.findById(bill.getBill_id());
		if(bill_1.isPresent()) {
			throw new BillException("bill already exists");
		}else {
			return billRepo.save(bill);
		}
		
		
	}

	@Override
	public Bill removeBill(Integer bill_id) throws BillException {
		Optional<Bill> bill_2= billRepo.findById(bill_id);
		if(bill_2.isPresent()) {
			Bill bill= bill_2.get();
			billRepo.delete(bill);
			return bill;
		}else {
		      throw new BillException("Bill does not exist with will Id "+ bill_id);
		}
		
	}

	public Bill updateBill(Integer bill_id) throws BillException {
        Optional<Bill> billUpdate= billRepo.findById(bill_id);
        Bill bill= new Bill();
		if(billUpdate.isPresent()) {
			Bill updatedBill = billUpdate.get();
			updatedBill.setBill_date(bill.getBill_date());
			updatedBill.setQuantity(bill.getQuantity());
			updatedBill.setBill_total(bill.getBill_total());
			
			return billRepo.save(updatedBill);
		}
		else {
		   throw new BillException("Bill is not found");
	}
}

	@Override
	public Bill viewBill(Integer bill_id) throws BillException {
		Optional<Bill> bills= billRepo.findById(bill_id);
		if(bills.isPresent()) {
			return bills.get();
		}else {
			throw new BillException("Bill not found");
		}
	}

	@Override
	public double totalBillById(Integer customer_id) throws MenuException, CustomerException {
		
		Optional<Customer> cOpt = customerRepo.findById(customer_id);
		if(cOpt.isPresent()) {
			Customer customer = cOpt.get();
			List<Menu> items = customer.getFoodCart().getMenuList();	
			if(items.size() > 0) {			
				Double total = 0.0;
				for(Menu item : items) {
					total += (item.getDish_price()*item.getQuantity()); 
				}
				
				return total;
				
			}else {
				throw new MenuException("No order items found for "+ customer.getCustomer_name());
			}
			
		}else {
			throw new CustomerException("No Customer found with ID: "+ customer_id);
		}
	}
	
	
//	updatedBill.setBill_date(bill.getBill_date());
//	updatedBill.setQuantity(bill.getBill_id());
//	updatedBill.setBill_total(bill.getBill_total());

}
