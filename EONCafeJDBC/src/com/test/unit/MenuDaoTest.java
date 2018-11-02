package com.test.unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//import com.dao.CustomerDaoImpl;
import com.dao.MenuDaoImpl;
import com.dao.VendorDaoImpl;
import com.model.Vendor;

public class MenuDaoTest
{

	private com.dao.MenuDao MenuDao;
	
	@Test
	 public void testgetMenu()
	 {
		 MenuDaoImpl menudaoimpl=new MenuDaoImpl();
		 int actual = menudaoimpl.getMenu(1).getMid();
		 int expected = menudaoimpl.getMenu(1).getMid();
		 assertEquals(expected,actual);
		 
		 
	 }
	
	
	@Test
	 public void testgetAllMenu()
	 {
		 MenuDaoImpl menudaoimpl=new MenuDaoImpl();
		 int actual = menudaoimpl.getAllMenu().size();
		 int expected = menudaoimpl.getAllMenu().size();
		 
		 System.out.println("Get all menu");
		 assertEquals(expected,actual);
		 
		 
	 }
	
	/*
	@Test
	 public void testremoveVendor()
	 {
		 MenuDaoImpl menudaoimpl=new MenuDaoImpl();
		 int actual = menudaoimpl.removeVendorMenu(actual);
		 int expected = menudaoimpl.removeVendorMenu(expected);;
		 
		 System.out.println("Get all menu");
		 assertEquals(expected,actual);
		 
		 
	 }
	 */
/*
/*
	@Test
	public void getaddMenu()
	{

		 MenuDaoImpl menudaoimpl=new MenuDaoImpl();
		 Vendor actual = menudaoimpl.addMenu();

		 System.out.println("Menu added!!");
		 Vendor expected = menudaoimpl.addMenu(1);
		 assertEquals(expected,actual);
		 
		
	}
*/
	/*
	@Test
	public void getUpdateMenu()
	{

		 MenuDaoImpl menudaoimpl=new MenuDaoImpl();
		// Vendor actual = menudaoimpl.updateMenu(80,2, 201);
		 Vendor actual = menudaoimpl.updateMenu();
		 System.out.println("Menu updated!!");
		 Vendor expected = menudaoimpl.updateMenu("90", "2","201");
		 assertEquals(expected,actual);
		 
		
	}
	
	*/
	
}
