package com.nexturn.demo.Controller;

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

import com.nexturn.demo.ExceptionHandling.BillException;
import com.nexturn.demo.ExceptionHandling.CustomerException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Bill;
import com.nexturn.demo.Service.BillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	
	BillService billservice;
	
	@PostMapping("/add")
	public ResponseEntity<Bill> generateBill(@RequestBody Bill bill) throws BillException{
		Bill mybill= billservice.addBill(bill);
		return new ResponseEntity<Bill>(mybill, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update/{bill_id}")
	public ResponseEntity<Bill> updateBill(@PathVariable Integer bill_id, @RequestBody Bill bill) throws BillException{
		Bill mybill= billservice.updateBill(bill_id, bill);
		return new ResponseEntity<Bill>(mybill, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{bill_id}")
	public ResponseEntity<Bill> deleteBill(@PathVariable int bill_id) throws BillException{
		Bill mybill= billservice.removeBill(bill_id);
		return new ResponseEntity<Bill>(mybill, HttpStatus.OK);
	}

	
	@GetMapping("/viewBill/{bill_id}")
	public ResponseEntity<Bill> viewBill(@PathVariable int bill_id) throws BillException{
		Bill mybill= billservice.viewBill(bill_id);
		return new ResponseEntity<Bill>(mybill, HttpStatus.FOUND);
	}
	
	@GetMapping("/totalBill/{customer_id}")
	public ResponseEntity<Double> totalBillByCustomerId(@PathVariable int customer_id) throws BillException, MenuException, CustomerException{
	     double total = billservice.totalBillById(customer_id);
		return new ResponseEntity<>(total,HttpStatus.OK);
	}


}
