package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Vendor;

/**
 * 
 * @author User
 *
 */
public class VendorDaoImpl implements VendorDao{

private static List<Vendor> allVendorsList=new ArrayList<Vendor>();
	
	
	/**
	 * This function is used to get the vendor using vendor id
	 */
	@Override
	public Vendor getVendor(int vid) 
	{
		// TODO Auto-generated method stub
		try {
			Vendor dummy=new Vendor();
			dummy.setVid(vid);
			//Studnet dummy=new Student(sid,"","");
			if(allVendorsList.contains(dummy))
			{
				int index=allVendorsList.indexOf(dummy);
				return allVendorsList.get(index);
			}
			//if not found from the list then get from db and add it to the list
		Connection connection=DBConnection.getConnection();
		String sqlQuery="select * from "+TABLEvendor+" where "+COLvid+" = "+"?";
		
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, vid);
			System.out.println(pst);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no student with this id
			if(rs.next()==false) return null;
			String vname=rs.getString(COLvname);
			String vpassword=rs.getString(COLvpassword);
			String vemail=rs.getString(COLvemail);
			
			Vendor vendor=new Vendor(vid,vname,vpassword,vemail);
			allVendorsList.add(vendor);
			return vendor;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	/**
	 * this function is used to get the list of vendors
	 */
	@Override
	public List<Vendor> getAllVendors()
	{
		allVendorsList=new ArrayList<Vendor>();
		try {
		Connection connection=DBConnection.getConnection();
		String sqlQuery="select * from " + TABLEvendor;
		
			PreparedStatement pst;
			
				pst = connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no student with this id
			while(rs.next())
			{
			
				int vid=rs.getInt(COLvid);
				String vname=rs.getString(COLvname);
				String vpassword=rs.getString(COLvpassword);
				String vemail=rs.getString(COLvemail);
				
				Vendor vendor=new Vendor(vid,vname,vpassword,vemail);
				allVendorsList.add(vendor);
			}
				return allVendorsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	/**
	 * This function is used to add vendor
	 */
	@Override
	public void addVendor(Vendor v) throws VendorExistsException
	{
		// TODO Auto-generated method stub
		if(allVendorsList.contains(v))
			throw new VendorExistsException();

		
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into " + TABLEvendor+" values(?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, v.getVid());
			pst.setString(2, v.getVname());
			pst.setString(3, v.getVpassword());
			pst.setString(4,v.getVemail());
					
			pst.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
/**
 * This function is used to delete a vendor
 */
	@Override
	public void deleteVendor(Vendor v) {
		// TODO Auto-generated method stub
		
		int vid=v.getVid();
		try{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEvendor+" where vid="+vid+";";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			int result=pst.executeUpdate();
			//ResultSet rs=pst.getResultSet();
			
			  Vendor dummy=new Vendor();
				
				dummy.setVid(vid);
				//find vendor in list only
				if(allVendorsList.contains(dummy))
				{
					
					allVendorsList.remove(dummy);
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
		
	
	
}
