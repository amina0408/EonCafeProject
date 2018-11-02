package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Customer;
import com.model.Order;


/**
 * 
 * @author User
 *This class provides order functionality
 */
public class OrderDaoImpl implements OrderDao{
	private static List<Order> allOrderslist = new ArrayList<Order>();
	private static List<Order> ordersbyvendors=new ArrayList<Order>();
	
	/**
	 * This function is used to get the order by passing customer id
	 */
	@Override
	public Order getOrder(int cid) {
		Connection connection=DBConnection.getConnection();
		String sql="select * from Order1 where cid=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.executeQuery();
			ResultSet rs=ps.getResultSet();
			while(rs.next())
			{
				int oid=rs.getInt(COLoid);
				int cid1=rs.getInt(COLcid);
				String cname=rs.getString(COLcname);
				
				String email=rs.getString(COLemail);
				int mid=rs.getInt(COLmid);
				int vid=rs.getInt(COLvid);
				String mname=rs.getString(COLmname);
				//byte status=rs.getByte(COLstatus);
				Order order=new Order(oid,cid1,vid,mid,cname,email,mname);
				return order;		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return null;
	}
	
	/**
	 * This function is used to get the list of orders
	 */
	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		Connection connection=DBConnection.getConnection();
		String sql="select * from Order1";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.executeQuery();
			ResultSet rs=ps.getResultSet();
			while(rs.next())
			{
				int oid=rs.getInt(COLoid);
				int cid1=rs.getInt(COLcid);
				String cname=rs.getString(COLcname);
				
				String email=rs.getString(COLemail);
				int mid=rs.getInt(COLmid);
				int vid=rs.getInt(COLvid);
				String mname=rs.getString(COLmname);
				//byte status=rs.getByte(COLstatus);
				Order order=new Order(oid,cid1,vid,mid,cname,email,mname);
				allOrderslist.add(order);
				
			}
			return allOrderslist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}
	
	/**
	 * This function is used to get the order by passing the vendor id
	 */
	@Override
	public List<Order> getOrderByVendorId(int vid) {
		
		
		Connection connection=DBConnection.getConnection();
		String sql="select * from Order1 where vid=?";
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, vid);
			ps.executeQuery();
			ResultSet rs=ps.getResultSet();
			while(rs.next())
			{
				int oid1=rs.getInt(COLoid);
				int cid1=rs.getInt(COLcid);
				String cname=rs.getString(COLcname);
				
				String email=rs.getString(COLemail);
				int mid=rs.getInt(COLmid);
				int vid1=rs.getInt(COLvid);	
				String mname=rs.getString(COLmname);
				
				Order order=new Order(oid1,cid1,vid1,mid,cname,email,mname);
				ordersbyvendors.add(order);
				//return order;		
			}
			return ordersbyvendors;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	/**
	 * This function is used to add order
	 */
	@Override
	public void addOrder(Order o) throws OrderExistsException
	{
		// TODO Auto-generated method stub
		if(allOrderslist.contains(o))
			throw new OrderExistsException();

		
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into "+TABLEOrder+"("+COLcid+","+COLcname+","+COLemail+","+COLvid+","+COLmid+","+COLmname+")"+" values(?,?,?,?,?,?)";
			//String sqlQuery="insert into " + TABLEOrder+"("+COLcid+","+COLcname+","+COLemail+","+ values(?,?,?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			//pst.setString(1, null);
			pst.setInt(1, o.getCid());
			pst.setString(2,o.getCname());
			pst.setString(3,o.getCemail());
			pst.setInt(4,o.getVid());
			pst.setInt(5, o.getMid());
			pst.setString(6,o.getMname());
					
			pst.executeUpdate();
			
			/*ResultSet rs = pst.getGeneratedKeys();
            if(rs != null && rs.next()){
               System.out.println("Generated Order Id: "+rs.getInt(1));
              o.setOid(rs.getInt(1));
              
            }*/
			
			
			
			
			allOrderslist.add(o);
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
	
	/**
	 * This function is used to delete the order
	 */
	@Override
	public void deleteOrder(int oid) {
		// TODO Auto-generated method stub
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEOrder+" where "+COLoid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,oid);
			 
			
			pst.executeUpdate();
			
			
			
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	
	
		
	}
	
