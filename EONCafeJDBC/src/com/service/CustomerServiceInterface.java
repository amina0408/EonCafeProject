package com.service;

import java.util.List;

import com.dao.CustomerExistsException;
import com.model.Customer;

/**
 * 
 * @author User
 *This interface provides functions as follows
 *{@link com.dao.CustomerDaoImpl#addCustomer(Customer)}
 *{@link com.dao.CustomerDaoImpl#getAllCustomers()}
 *{@link com.dao.CustomerDaoImpl#getCustomer(int)}
 */
public interface CustomerServiceInterface {
	Customer getCustomer(int cid);
	List<Customer> getAllCustomer();
	void addCustomer(Customer c) throws CustomerExistsException;
	
}
