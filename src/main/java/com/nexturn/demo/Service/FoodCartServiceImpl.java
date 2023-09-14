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
	

	@Override
	public List<FoodCart> saveCart(List<FoodCart> cart) throws FoodCartException {
		cart.forEach(cart1 ->{
//			Optional<FoodCart> opt = fcRepo.findById(cart1.getCart_id());
			Optional<Customer> custOpt= custRepo.findById(cart1.getCustomer_id());
			Optional<Menu> menuOpt= menuRepo.findById(cart1.getMenu_id());			
			if(custOpt.isPresent() && menuOpt.isPresent()) {
				 fcRepo.save(cart1);
//				throw new FoodCartException("Cart already exists..");
			}else {
				 System.out.println("jhsdhgshdfg");
		}
			
		});
		return null;
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
