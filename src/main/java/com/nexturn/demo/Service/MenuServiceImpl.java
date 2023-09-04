package com.nexturn.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Model.Menu;
import com.nexturn.demo.Repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	MenuRepository menuRepo;


	public Menu addMenu(Menu menu) throws MenuException {
		Optional<Menu> opt = menuRepo.findById(menu.getMenu_id());
		if(opt.isPresent()) {
			throw new MenuException("menu already exists..");
		}else {
			return menuRepo.save(menu);
		}
	}
	
	
	public Menu updateMenu(Menu menu) throws MenuException {
		Optional<Menu> menue= menuRepo.findById(menu.getMenu_id());
		if(menue.isPresent()) {
			Menu updatedMenu = menue.get();
			updatedMenu.setDish_name(menu.getDish_name());
			updatedMenu.setCategory(menu.getCategory());
			updatedMenu.setDish_price(menu.getDish_price());
			updatedMenu.setQuantity(menu.getQuantity());
			
		
			return menuRepo.save(updatedMenu);
		}
		else {
		   throw new MenuException("Menu with Id "+ menu.getMenu_id() +" is not found");
	}
}

	
	public Menu viewMenu(Integer menu_id) throws MenuException {
		Optional<Menu> opt = menuRepo.findById(menu_id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new MenuException("No Item found with ID: "+menu_id);
		}
	}


	public Menu removeMenu(Integer menu_id) throws MenuException {
		Optional<Menu> opt = menuRepo.findById(menu_id);
		if(opt.isPresent()) {
			Menu item = opt.get();
			menuRepo.delete(item);
			return item;
		}else {
			throw new MenuException("No Item found with ID: "+menu_id);
		}
	}

	
	
	public List<Menu> viewAllItems() throws MenuException {
		List<Menu> items = menuRepo.findAll();
		if(items.size() > 0) {
			return items;
		}else {
			throw new MenuException("No Item exists..");
		}
	}

		
		public List<Menu> viewAllMenus() throws MenuException {
			// TODO Auto-generated method stub
			return null;
		}
		
	
		
//	public Menu updateMenu(Menu menu) throws MenuException {
//			Optional<Menu> opt = menuRepo.findById(menu.getMenu_id());
//			if(opt.isPresent()) {
//				return menuRepo.save(menu);
//			}else {
//				throw new MenuException("No such Item found..");
//			}
//		}

}

