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

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Service.FoodCartService;

@RestController
@RequestMapping("/cart")
public class FoodCartController {
	
	@Autowired
	FoodCartService fcservice;
	
	@PostMapping("/register")
	public ResponseEntity<FoodCart> saveCartDetails(@RequestBody FoodCart foodcart) throws FoodCartException{
		FoodCart fcart= fcservice.saveCart(foodcart);
		return new ResponseEntity<FoodCart>(fcart, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{cart_id}/{menu_id}")
	public ResponseEntity<FoodCart> addItemToCart(@PathVariable int cart_id, @PathVariable int menu_id) throws FoodCartException, MenuException{
		FoodCart fcart= fcservice.addItem(cart_id, menu_id);
		return new ResponseEntity<FoodCart>(fcart,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/view/{cart_id}")
	public ResponseEntity<FoodCart> viewCart(@PathVariable int cart_id) throws FoodCartException{
		FoodCart fcart= fcservice.viewCart(cart_id);
		return new ResponseEntity<FoodCart>(fcart, HttpStatus.FOUND);
	}
	
	@DeleteMapping("/remove/{cart_id}")
	public ResponseEntity<FoodCart> removeCart(@PathVariable int cart_id) throws FoodCartException{
		FoodCart fcart= fcservice.clearCart(cart_id);
		return new ResponseEntity<FoodCart>(fcart, HttpStatus.OK);
	}
	
	

}
