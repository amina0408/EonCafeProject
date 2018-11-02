package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Customer;
import com.model.Vendor;


/**
 * 
 * @author User
 *This class provides functionalities of customer
 */
public class CustomerDaoImpl implements CustomerDao {

private static List<Customer> allCustomerList=new ArrayList<Customer>();
	
	
	/**
	 * This function is used to get the customer byt passing customer id
	 */
	@Override
	public Customer getCustomer(int cid) 
	{
		// TODO Auto-generated method stub
		try {
			Customer dummy=new Customer();
			dummy.setCid(cid);
			
			if(allCustomerList.contains(dummy))
			{
				int index=allCustomerList.indexOf(dummy);
				return allCustomerList.get(index);
			}
			//if not found from the list then get from db and add it to the list
		Connection connection=DBConnection.getConnection();
		String sqlQuery="select * from "+TABLEcustomer+" where "+COLcid+" = "+"?";
		
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			System.out.println(pst);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no customer with this id
			if(rs.next()==false) return null;
			String cname=rs.getString(COLcname);
			String cpassword=rs.getString(COLcpassword);
			String cemail=rs.getString(COLcemail);
			
			Customer customer=new Customer(cid,cname,cemail,cpassword);
			allCustomerList.add(customer);
			return customer;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * This function is used to get the list of customers
	 */
	@Override
	public List<Customer> getAllCustomers()
	{
		allCustomerList=new ArrayList<Customer>();
		try {
		Connection connection=DBConnection.getConnection();
		String sqlQuery="select * from " + TABLEcustomer;
		
			PreparedStatement pst;
			
				pst = connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no customer with this id
			while(rs.next())
			{
			
				int cid=rs.getInt(COLcid);
				String cname=rs.getString(COLcname);
				String cpassword=rs.getString(COLcpassword);
				String cemail=rs.getString(COLcemail);
				
				Customer customer=new Customer(cid,cname,cemail,cpassword);
				allCustomerList.add(customer);
				
			}
				return allCustomerList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This function is used to add the customer
	 */
	@Override
	public void addCustomer(Customer c) throws CustomerExistsException
	{
		// TODO Auto-generated method stub
		if(allCustomerList.contains(c))
			throw new CustomerExistsException();

		
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into " + TABLEcustomer+" values(?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, c.getCid());
			pst.setString(2,c.getCname());
			pst.setString(3, c.getCemail());
			pst.setString(4,c.getCpassword());
					
			pst.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
}
