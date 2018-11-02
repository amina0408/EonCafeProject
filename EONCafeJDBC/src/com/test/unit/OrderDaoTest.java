package com.test.unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dao.OrderDaoImpl;

public class OrderDaoTest 
{

	@Test
	 public void testgetMenu()
	 {
		 OrderDaoImpl orderdaoimpl=new OrderDaoImpl();
		 int actual = orderdaoimpl.getOrder(101).getOid();
		 int expected = orderdaoimpl.getOrder(101).getOid();
		 assertEquals(expected,actual);
		 
		 System.out.println("order 1");
		 
		 
	 }

	
	

}
