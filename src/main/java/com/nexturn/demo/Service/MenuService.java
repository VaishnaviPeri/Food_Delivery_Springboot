package com.nexturn.demo.Service;

import java.util.List;

import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Menu;

public interface MenuService {
	public Menu addMenu(Menu Menu) throws MenuException;

	public Menu updateMenu(Integer menu_id) throws MenuException;

	public Menu viewMenu(Integer MenuId) throws MenuException;

	public Menu removeMenu(Integer MenuId) throws MenuException;

	public List<Menu> viewAllMenus() throws MenuException;

}
