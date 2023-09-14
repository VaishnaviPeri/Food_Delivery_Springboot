package com.nexturn.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Repository.CustomerRepository;
import com.nexturn.demo.Repository.FoodCartRepository;
import com.nexturn.demo.Repository.MenuRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService{
	
	@Autowired
	FoodCartRepository fcRepo;
	@Autowired
	MenuRepository menuRepo;
	@Autowired
	CustomerRepository custRepo;
	
	
	private Menu menu;
	

	@Override
	public List<FoodCart> saveCart(List<FoodCart> foodcart) throws FoodCartException {
		    for(FoodCart cart1: foodcart) {
//			Optional<FoodCart> opt = fcRepo.findById(cart1.getCart_id());		
			Optional<Customer> custOpt= custRepo.findById(cart1.getCustomer_id());
			Optional<Menu> menuOpt= menuRepo.findById(cart1.getMenu().getMenu_id());			
			if(custOpt.isEmpty() || menuOpt.isEmpty()) {
				throw new FoodCartException("Customer or menu not found for cart entry: " + cart1.getCart_id());
			}
//			foodcart.setMenu(menu);
			 Menu menu = menuOpt.get();
		     cart1.setMenu(menu);
			fcRepo.save(cart1);
		    }
	
		return foodcart;
		}
		
//		Optional<FoodCart> opt = fcRepo.findById(cart.getCart_id());
//		if(opt.isPresent()) {
//			throw new FoodCartException("Cart already exists..");
//		}else {
//			 return fcRepo.saveAll(cart);
//		}
		
	

//	@Override
//	public FoodCart addItem(Integer cart_id, Integer menu_id) throws FoodCartException, MenuException {
//		Optional<FoodCart> cOpt = fcRepo.findById(cart_id);
//		if(cOpt.isPresent()) {
//			
//			Optional<Menu> iOpt = menuRepo.findById(menu_id);
//			if(iOpt.isPresent()) {
//				
//				FoodCart cart = cOpt.get();
//			    Menu item = iOpt.get();
//				List<Menu> list = new ArrayList<>();
//				list.add(cart.getMenu_id());
//				list.add(item);
//				cart.setMenu_id(item);
//				
//				return cart;
//				
//			}else {
//				throw new MenuException("No Item found with ID: "+menu_id);
//			}
//			
//		}else {
//			throw new FoodCartException("No Cart found with ID: "+menu_id);
//		}
//	}

	@Override
	public FoodCart clearCart(Integer cart_id) throws FoodCartException {
		Optional<FoodCart> opt = fcRepo.findById(cart_id);
		if(opt.isPresent()) {
			FoodCart foodcart = opt.get();
			fcRepo.delete(foodcart);
//			return cart;
		}else {
			throw new FoodCartException("No Cart found with ID: "+cart_id);
		}
		return null;
	}

	
//	@Override
//	public FoodCart viewCart(Integer cart_id) throws FoodCartException {
//		Optional<FoodCart> opt = fcRepo.findByCart_id(cart_id);
//		if(opt.isPresent()) {
//			FoodCart foodcart = opt.get();
//			return foodcart;
//		}else {
//			throw new FoodCartException("No Cart found with ID: "+ cart_id);
//		}
//	}
	

	    public List<Menu> viewCart(Integer cart_id) throws FoodCartException {
	        List<FoodCart> cartItems = fcRepo.findByCart_id(cart_id);

	        if (cartItems.isEmpty()) {
	            throw new FoodCartException("No Cart found with ID: " + cart_id);
	        }

	        List<Menu> menus = new ArrayList<>();
	        for (FoodCart cartItem : cartItems) {
	            menus.add(cartItem.getMenu());
	        }

	        return menus;
	    }
	}


	


