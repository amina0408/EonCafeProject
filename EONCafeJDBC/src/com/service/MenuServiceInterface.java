package com.service;

import java.util.List;

import com.dao.MenuExistsException;
import com.model.Menu;

/**
 * 
 * @author User
 *This interface provides following function
 *{@link com.dao.MenuDaoImpl#getAllMenu()}
 *{@link com.dao.MenuDaoImpl#addMenu(Menu)}
 *{@link com.dao.MenuDaoImpl#getMenu(int)}
 *{@link com.dao.MenuDaoImpl#removeVendorMenu(int)}
 *{@link com.dao.MenuDaoImpl#updateMenu(int, int, int)}
 */

public interface MenuServiceInterface {

	List<Menu> getAllMenu();

	void deleteVendorMenu(int vid);


	//void updateMenu(Menu m);

	Menu getmenu(int mid);

	void addMenu(Menu m) throws MenuExistsException;

	void updateMenu(int mprice, int mid,int vid);
	
	
}
