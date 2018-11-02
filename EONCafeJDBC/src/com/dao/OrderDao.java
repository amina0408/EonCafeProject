package com.dao;

import java.util.List;

import com.model.Order;


/**
 * 
 * @author User
 *This interFace provides the following functionalities
 *{@link com.dao.OrderDaoImpl#addOrder(Order)}
 *{@link com.dao.OrderDaoImpl#deleteOrder(int)}
 *{@link com.dao.OrderDaoImpl#getAllOrders()}
 *{@link com.dao.OrderDaoImpl#getOrderByVendorId(int)}
 *{@link com.dao.OrderDaoImpl#getOrder(int)}
 */
public interface OrderDao 
{
	String TABLEOrder="Order1",COLoid="oid",COLcid="cid",COLcname="cname",COLemail="cemail",COLvid="vid",COLmid="mid",COLstatus="status",COLmname="mname";
	public Order getOrder(int cid);
	public List<Order> getAllOrders();
	public List<Order> getOrderByVendorId(int vid);
	void addOrder(Order o) throws OrderExistsException;
	public void deleteOrder(int oid);
}