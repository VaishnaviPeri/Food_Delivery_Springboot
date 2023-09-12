package com.nexturn.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Repository.FoodCartRepository;
import com.nexturn.demo.Repository.MenuRepository;

@Service
public class FoodCartServiceImpl implements FoodCartService{
	
	@Autowired
	FoodCartRepository fcRepo;
	@Autowired
	MenuRepository menuRepo;

	@Override
	public FoodCart saveCart(FoodCart cart) throws FoodCartException {
		Optional<FoodCart> opt = fcRepo.findById(cart.getCart_id());
		if(opt.isPresent()) {
			throw new FoodCartException("Cart already exists..");
		}else {
			 return fcRepo.save(cart);
		}
		
	}

	@Override
	public FoodCart addItem(Integer cart_id, Integer menu_id) throws FoodCartException, MenuException {
		Optional<FoodCart> cOpt = fcRepo.findById(cart_id);
		if(cOpt.isPresent()) {
			
			Optional<Menu> iOpt = menuRepo.findById(menu_id);
			if(iOpt.isPresent()) {
				
				FoodCart cart = cOpt.get();
			    Menu item = iOpt.get();
				List<Menu> list = new ArrayList<>();
				list.addAll(cart.getMenuList());
				list.add(item);
				cart.setMenuList(list);
				
				return cart;
				
			}else {
				throw new MenuException("No Item found with ID: "+menu_id);
			}
			
		}else {
			throw new FoodCartException("No Cart found with ID: "+menu_id);
		}
	}

	@Override
	public FoodCart clearCart(Integer cartId) throws FoodCartException {
		Optional<FoodCart> opt = fcRepo.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			fcRepo.delete(cart);
			return cart;
		}else {
			throw new FoodCartException("No Cart found with ID: "+cartId);
		}
	}

	@Override
	public FoodCart viewCart(Integer cartId) throws FoodCartException {
		Optional<FoodCart> opt = fcRepo.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			return cart;
		}else {
			throw new FoodCartException("No Cart found with ID: "+cartId);
		}
	}

}
