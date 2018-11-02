package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CustomerDao;
import com.dao.CustomerDaoImpl;
import com.dao.CustomerExistsException;
import com.model.Customer;
import com.model.Menu;
/**
 * 
 * @author User
 *This class provides Customer services
 */

public class CustomerService implements CustomerServiceInterface{

	private static List<Customer> allCustomerList=new ArrayList<Customer>();
	CustomerDao customerdaoimpl=new CustomerDaoImpl();

	/**
	 * This function is used to get the customer
	 * @param cid represents customer id
	 * @return the customer information
	 */
		public Customer getCustomer(int cid)
		{
			Customer customer=customerdaoimpl.getCustomer(cid);
			return customer;
			
		}
		
		/*public List<Customer> getAllCustomer() {
			allCustomerList = new ArrayList<Customer>();
			allCustomerList = customerdaoimpl.getAllCustomers();
			return allCustomerList;

		}*/
		
		/**
		 * This function is used to add customer
		 * 
		 */
		public void addCustomer(Customer c) throws CustomerExistsException
		{
			customerdaoimpl.addCustomer(c);
		}

		//@Override
		/**
		 * This function is used to get all customers 
		 * @return list of customers
		 */
		public List<Customer> getAllCustomer() {
			allCustomerList = new ArrayList<Customer>();
			allCustomerList = customerdaoimpl.getAllCustomers();
			return allCustomerList;

		}
		
		
		
		
	
	
}
