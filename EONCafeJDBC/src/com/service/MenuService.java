package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.MenuDao;
import com.dao.MenuDaoImpl;
import com.dao.MenuExistsException;
import com.model.Menu;
import com.model.Order;


/**
 * 
 * @author User
 *This class provides menu related services
 */
public class MenuService implements MenuServiceInterface {

	
	private static List<Menu> allMenuList=new ArrayList<Menu>();
	MenuDao menudaoimpl=new MenuDaoImpl();
/**
 * This function is used to get the menu by menu id
 * @param mid represents menu id
 * @return menu
 */
		public Menu getmenu(int mid)
		{
			Menu menu=menudaoimpl.getMenu(mid);
			return menu;
			
		}
		
		/**
		 * This function returns the list of menus
		 * @return menu list
		 */
		public List<Menu> getAllMenu() {
			allMenuList = new ArrayList<Menu>();
			allMenuList = menudaoimpl.getAllMenu();
			return allMenuList;

		}
		
		/**
		 * This function is used to add menu to the menu table
		 * 
		 */
		public void addMenu(Menu m) throws MenuExistsException
		{
			menudaoimpl.addMenu(m);
		}
		
		/**
		 * This function is used to update the menu 
		 * @param mprice represents menu price
		 * @param mid represents menu id
		 * @param vid represents vendor id
		 */
		
		public void updateMenu(int mprice,int mid,int vid)
		{
			menudaoimpl.updateMenu(mprice,mid,vid);
		}
		
		/**
		 * This function is used to delete the menu of vendors
		 * @param vid represnets the vendor id
		 */
		public void deleteVendorMenu(int vid)
		{
			menudaoimpl.removeVendorMenu(vid);
		}
	
	
}
