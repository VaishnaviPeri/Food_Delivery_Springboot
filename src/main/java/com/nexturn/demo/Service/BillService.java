package com.nexturn.demo.Service;

import com.nexturn.demo.ExceptionHandling.BillException;
import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Bill;

public interface BillService {
	
	public Bill generateBill(Integer cart_id) throws BillException;
	
//	public Bill removeBill(Integer bill) throws BillException;
//	
//	public Bill updateBill(Integer bill_id, Bill bill) throws BillException;
//	
//	public Bill viewBill(Integer bill_id) throws BillException;
	
//	public double totalBillById(Integer customer_id) throws BillException, MenuException, CustomerException;

//	public Bill updateBill(Integer bill_id);
	
	

}
