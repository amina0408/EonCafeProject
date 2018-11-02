package com.service;


import java.util.ArrayList;
import java.util.List;

import com.dao.OrderDao;
import com.dao.OrderDaoImpl;
import com.dao.OrderExistsException;
import com.dao.VendorExistsException;
import com.model.Order;
import com.model.Vendor;
/**
 * 
 * @author User
 *This class provides various functions related to order table
 *
 */

public class OrderService implements OrderServiceInterface{

	private static List<Order> allOrdersList = new ArrayList<Order>();
	OrderDao orderdaoimpl = new OrderDaoImpl();

	/**
	 * This function is udes to get the order by using customer id
	 * @param cid represents the customer id
	 */
	public Order getorder(int cid) {
		Order order = orderdaoimpl.getOrder(cid);
		return order;

	}

	/**
	 * This function used to get the list of orders
	 * 
	 */
	public List<Order> getAllOrders() {
		allOrdersList = new ArrayList<Order>();
		allOrdersList = orderdaoimpl.getAllOrders();
		return allOrdersList;

	}

	/**
	 * This function is used to get the order by using vendor id
	 * @param vid represents vendor id
	 */
	public List<Order> getorderbyvendorid(int vid) {
		allOrdersList = new ArrayList<Order>();
		//Order order = orderdaoimpl.getOrderByVendorId(vid);
		allOrdersList=orderdaoimpl.getOrderByVendorId(vid);
		return allOrdersList;

	}
/**
 * This function is used to add order
 * 
 */
	public void addorder(Order o) throws OrderExistsException
	{
		orderdaoimpl.addOrder(o);
	}

	/**
	 * This function is used to delete order from the order table
	 * @param oid represents order id
	 */
	@Override
	public void deleteorder(int oid) {
		// TODO Auto-generated method stub
		orderdaoimpl.deleteOrder(oid);
	}

	
	
	
	
}
