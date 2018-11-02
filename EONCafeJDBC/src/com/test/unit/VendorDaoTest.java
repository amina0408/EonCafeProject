package com.test.unit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.VendorDao;
import com.dao.VendorDaoImpl;
import com.model.Vendor;

public class VendorDaoTest
{

	/*
	@Test
	public void testaddvendor() 
	{

		//fail("Not yet implemented");
		
		Vendor vendor1= new Vendor(207,"zumboBar","zumbobar@gmail.com","zumbo1");
		
		
		List<Vendor> vendor2 = VendorDaoImpl.addVendor();
		//List<VendorDao> vendordao = new VendorDaoImpl().addVendor();
		Assert.assertEquals(vendor2.size(),vendor2.size());
		
		
	}
	*/

	@Test
	public void testgetVendor1() 
	{
		
			 VendorDaoImpl vendordaoimpl=new VendorDaoImpl();
			 Vendor actual = vendordaoimpl.getVendor(201);
			 Vendor expected = vendordaoimpl.getVendor(201);
			 assertEquals(expected,actual);
			 
			 System.out.println("First vendor");
			 
			 
		 }
	
	@Test
	public void testgetVendor() 
	{
		
			 VendorDaoImpl vendordaoimpl=new VendorDaoImpl();
			 Vendor actual = vendordaoimpl.getVendor(202);
			 Vendor expected = vendordaoimpl.getVendor(202);
			 assertEquals(expected,actual);
			 
			 System.out.println("First vendor");
			 
			 
		 }
	
	@Test
	public void getallVendor()
	{
		VendorDaoImpl vendordaoimpl=new VendorDaoImpl();
		
		List<Vendor> actual=vendordaoimpl.getAllVendors();
		List<Vendor> expected=vendordaoimpl.getAllVendors();
		System.out.println("all vendors done");
		assertEquals(expected,actual);
		
		
	}
	
	
	}


