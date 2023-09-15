package com.nexturn.demo.Service;

import java.util.List;

import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Menu;

public interface MenuService {
	public Menu addMenu(Integer restaurant_id, Menu menu) throws MenuException;

	public Menu updateMenu1(Integer menu_id,Menu menu) throws MenuException;

	public Menu viewMenu(Integer menu_id) throws MenuException;

	public List<Menu> viewAllItems() throws MenuException;
	
	public void deleteMenuByDishName(String dish_name) throws MenuException;

}
