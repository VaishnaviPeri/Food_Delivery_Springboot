package com.nexturn.demo.Controller;

import java.util.List;

import org.apache.coyote.http11.Http11InputBuffer;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Service.MenuService;

@RestController()
@RequestMapping("/menu")
@CrossOrigin(origins="*")
public class MenuController {
	
	@Autowired
	MenuService mservice;

	
	@PostMapping("/add/{restaurant_id}")
	public ResponseEntity<Menu> addItem(@PathVariable int restaurant_id,@RequestBody Menu menu ) throws MenuException{
		try {
		Menu addedMenu= mservice.addMenu(restaurant_id, menu);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedMenu);
		}catch(MenuException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
}
	
	@PutMapping("/update/{menu_id}")
	public ResponseEntity<Menu> updateMenu(@PathVariable Integer menu_id, @RequestBody Menu men) throws MenuException{
		Menu menu= mservice.updateMenu(menu_id,men);
		return new ResponseEntity<Menu>(menu, HttpStatus.ACCEPTED);
				
	}
	
	@GetMapping("/view/{menu_id}")
	public ResponseEntity<Menu> viewMenu(@PathVariable Integer menu_id) throws MenuException{
		try {
			Menu menu= mservice.viewMenu(menu_id);
			return new ResponseEntity<Menu>(menu,HttpStatus.OK);
		}catch(MenuException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@GetMapping("/viewallitems")
	public ResponseEntity<List<Menu>> getAllItems() throws MenuException{
		List<Menu> item= mservice.viewAllItems();
		return new ResponseEntity<List<Menu>>(item,HttpStatus.FOUND);
	}
	
	
//	@GetMapping("/viewbydish_name/{dish_name}")
//	public ResponseEntity<List<Menu>> searchByDishName(@RequestParam String dish_name) throws MenuException{
//		List<Menu> menus = mservice.searchByDish_name(dish_name);
//		return new ResponseEntity<List<Menu>>(menus,HttpStatus.FOUND);
//	}
	

	@DeleteMapping("/remove/{menu_Id}")
	public ResponseEntity<Menu> removeItem(@PathVariable Integer menu_id) throws MenuException{
		Menu removedItem = mservice.removeMenu(menu_id);
		return new ResponseEntity<Menu>(removedItem, HttpStatus.OK);
	}






















}