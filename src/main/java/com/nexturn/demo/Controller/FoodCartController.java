package com.nexturn.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Service.FoodCartService;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins="*")
public class FoodCartController {
	
	@Autowired
	FoodCartService fcservice;
	
//	@PostMapping(value="/save",consumes)
	@PostMapping(path = "save", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FoodCart>> saveCartDetails(@RequestBody List<FoodCart> foodcart) throws FoodCartException{
		List<FoodCart> fcart= fcservice.saveCart(foodcart);
		return new ResponseEntity<List<FoodCart>>(fcart, HttpStatus.CREATED);
	}
	
	
	
//	@PutMapping("/update/{cart_id}/{menu_id}")
//	public ResponseEntity<FoodCart> addItemToCart(@PathVariable int cart_id, @PathVariable int menu_id) throws FoodCartException, MenuException{
//		FoodCart fcart= fcservice.addItem(cart_id, menu_id);
//		return new ResponseEntity<FoodCart>(fcart,HttpStatus.ACCEPTED);
//	}
	
//	@GetMapping("/view/{cart_id}")
//	public ResponseEntity<FoodCart> viewCart(@PathVariable int cart_id) throws FoodCartException{
//		FoodCart fcart= fcservice.viewCart(cart_id);
//		return new ResponseEntity<FoodCart>(fcart, HttpStatus.FOUND);
//	}
	
	
	@GetMapping("/view/{cart_id}")
    public ResponseEntity<List<Menu>> viewCart(@PathVariable int cart_id) {
        try {
            List<Menu> menus = fcservice.viewCart(cart_id);
            return new ResponseEntity<>(menus, HttpStatus.OK);
        } catch (FoodCartException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	
	
	@DeleteMapping("/remove/{cart_id}")
	public ResponseEntity<FoodCart> removeCart(@PathVariable int cart_id) throws FoodCartException{
		FoodCart fcart= fcservice.clearCart(cart_id);
		return new ResponseEntity<FoodCart>(fcart, HttpStatus.OK);
	}
	
	

}
