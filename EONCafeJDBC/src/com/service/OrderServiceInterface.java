package com.service;

import java.util.List;

import com.dao.OrderExistsException;
import com.model.Order;
/**
 * 
 * @author User
 *This includes following methods
 *{@link com.dao.OrderDaoImpl#getAllOrders()}
 *{@link com.dao.OrderDaoImpl#deleteOrder(int)}
 *{@link com.dao.OrderDaoImpl#addOrder(Order)}
 *{@link com.dao.OrderDaoImpl#getOrder(int)}
 *{@link com.dao.OrderDaoImpl#getOrderByVendorId(int)}
 */
public interface OrderServiceInterface {

	
	public Order getorder(int cid);
	public List<Order> getAllOrders();
	public List<Order> getorderbyvendorid(int vid);
	public void addorder(Order o) throws OrderExistsException;
	//public void deleteOrder(int oid);
	void deleteorder(int oid);
}
