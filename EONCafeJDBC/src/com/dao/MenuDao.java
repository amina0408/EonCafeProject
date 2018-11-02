package com.dao;

import java.util.List;

import com.model.Menu;
import com.model.Vendor;

/**
 * 
 * @author User
 *This interface provides the following function
 *{@link com.dao.MenuDaoImpl#addMenu(Menu)}
 *{@link com.dao.MenuDaoImpl#getAllMenu()}
 *{@link com.dao.MenuDaoImpl#getMenu(int)}
 *{@link com.dao.MenuDaoImpl#removeVendorMenu(int)}
 *{@link com.dao.MenuDaoImpl#updateMenu(int, int, int)}
 */
public interface MenuDao {

	String TABLEmenu="Menu",COLmid="mid",COLvid="vid";
	String COLmname="mname",COLmprice="mprice",COLvname="vname";
	
	List<Menu> getAllMenu();

	void removeVendorMenu(int vid);


	//void updateMenu(Menu m);

	Menu getMenu(int mid);

	void addMenu(Menu m) throws MenuExistsException;

	void updateMenu(int mprice, int mid,int vid);

}
