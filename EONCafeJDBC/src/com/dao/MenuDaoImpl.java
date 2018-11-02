package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Menu;
import com.model.Vendor;
import com.main.DBConnection;

/**
 * 
 * @author User
 *This class provides functions related to menu
 */
public class MenuDaoImpl implements MenuDao {
	private static List<Menu>allMenuList=new ArrayList<Menu>();
	
	/**
	 * This function is used to get the menu information by passing the menu id
	 */
	@Override
	public Menu getMenu(int mid) 
	{
		// TODO Auto-generated method stub
		try {
			Menu dummy=new Menu();
			dummy.setMid(mid);
	
			if(allMenuList.contains(dummy))
			{
				int index=allMenuList.indexOf(dummy);
				return allMenuList.get(index);
			}
			//if not found from the list then get from db and add it to the list
		Connection connection=DBConnection.getConnection();
		String sqlQuery="select * from "+TABLEmenu+" where "+COLmid+" = "+"?";
		
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, mid);
			System.out.println(pst);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no student with this id
			if(rs.next()==false) return null;
			
			int vid=rs.getInt(COLvid);
			String mname=rs.getString(COLmname);
			int mprice=rs.getInt(COLmprice);
			String vname=rs.getString(COLvname);
		
			Menu menu=new Menu(mid,vid,mname,mprice,vname);
			
			allMenuList.add(menu);
			return menu;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	
	/**
	 * This function is used to get the list of menus
	 */
	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		
		allMenuList=new ArrayList<Menu>();
		try {
			
			
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEmenu;
			
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			
			while(rs.next())
			{
				int mid=rs.getInt(COLmid);
				int vid=rs.getInt(COLvid);
				String mname=rs.getString(COLmname);
				int mprice=rs.getInt(COLmprice);
				String vname=rs.getString(COLvname);
			
				Menu menu=new Menu(mid,vid,mname,mprice,vname);
				
				allMenuList.add(menu);
				
			}
			
			
			
			return  allMenuList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

		
		
	}
	
	/**
	 * This function is used to delete the menu using the vendor id
	 */
	@Override
	public void removeVendorMenu(int vid)
	{
		
		try{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEmenu+" where vid="+vid+";";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			int result=pst.executeUpdate();
			//ResultSet rs=pst.getResultSet();
			
			  Menu dummy=new Menu();
				
				dummy.setVid(vid);
				//find menu in list only
				if(allMenuList.contains(dummy))
				{
					
					allMenuList.remove(dummy);
				}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		}
		
	/*@Override
	public void updateMenu(Menu m)
	{
		
		try
		{
			//int sid=s.getSid();
			Connection connection=DBConnection.getConnection();
			String sqlQuery="update "+TABLEmenu+" set "+COLmprice+" =?"+" where mid="+ m.getMid() +";";
					
			PreparedStatement pst=connection.prepareStatement(sqlQuery);

			
			pst.setInt(1,m.getMprice());
			
			
			pst.executeUpdate();
			
			for(Menu menu:allMenuList)
			{
				if(menu.getMid()==m.getMid())
				{
					menu.setMprice(m.getMprice());
				}
			}

			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		
	}
	*/
	
	/**
	 * This function is used to update the menu by using menu price,menu id,vendor id
	 */
	@Override
	public void updateMenu(int mprice,int mid,int vid)
	{
		
		try
		{
			//int sid=s.getSid();
			Connection connection=DBConnection.getConnection();
			//String sqlQuery="update "+TABLEmenu+" set "+COLmprice+" =?"+" where mid="+ mid +";";
			String sqlQuery="update Menu set mprice=? where mid=? and vid=?";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);

			
			pst.setInt(1,mprice);
			pst.setInt(2,mid);
			pst.setInt(3,vid);
			
			pst.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}	
	
	/**
	 * This function is used to add menu 
	 */
	@Override
	public void addMenu(Menu m) throws MenuExistsException
	{
		// TODO Auto-generated method stub
		if(allMenuList.contains(m))
			throw new MenuExistsException();

		
		try
		{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into " + TABLEmenu+" values(?,?,?,?)";
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			//pst.setInt(1, m.getMid());
			pst.setInt(1, m.getVid());
			pst.setString(2, m.getMname());
			pst.setInt(3, m.getMprice());
			pst.setString(4, m.getVname());
			
			pst.executeUpdate();
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}
	
	
	
}
