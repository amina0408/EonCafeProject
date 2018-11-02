package com.dao;

import java.util.List;

import com.model.Customer;
import com.model.Vendor;

/**
 * 
 * @author User
 *This interface includes following functions
 *{@link com.dao.CustomerDaoImpl#addCustomer(Customer)}
 *{@link com.dao.CustomerDaoImpl#getAllCustomers()}
 *{@link com.dao.CustomerDaoImpl#getCustomer(int)}
 */
public interface  CustomerDao {

	String TABLEcustomer="Customer",COLcid="cid",COLcname="cname";
	String COLcpassword="cpassword",COLcemail="cemail";
	
	
	Customer getCustomer(int cid);
	List<Customer> getAllCustomers();
	void addCustomer(Customer c) throws CustomerExistsException;
	
	
	
}
