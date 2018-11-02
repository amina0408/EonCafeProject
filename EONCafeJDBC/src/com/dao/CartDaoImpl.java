package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.main.DBConnection;
import com.model.Cart;
import com.model.Menu;





public class CartDaoImpl implements CartDao
{
	
	private static List<Cart>allCartList=new ArrayList<Cart>();
	
	
	
	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="insert into "+TABLEcart+" values(?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1,cart.getCartId());
			pst.setInt(2,cart.getVid());
			pst.setString(3,cart.getVname());
			pst.setInt(4,cart.getMid());
			pst.setString(5,cart.getMname());
			pst.setInt(6,cart.getMprice());
			pst.setInt(7,cart.getQuantity());
			pst.setInt(8,cart.getDiscount());
			
			pst.executeUpdate();
			allCartList.add(cart);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	@Override
	public void deleteCart(Cart cart) {
		// TODO Auto-generated method stub
		
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="delete from "+TABLEcart+" where "+COLcid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,cart.getCartId());
			 
			System.out.println("deleted cart:"+cart);
			pst.executeUpdate();
			
			allCartList.remove(cart);
			
			
//			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	
	
	
	
	
	
	@Override
	public Cart getcart(int cid) {
		// TODO Auto-generated method stub
		try {
			Cart dummy=new Cart();
			dummy.setCartId(cid);
			
			if(allCartList.contains(dummy))
			{
				
			int index=allCartList.indexOf(dummy);
			return allCartList.get(index);
			}
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEcart+" where "+COLcid+"="+"?";
			
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			
			
		    int cartId=rs.getInt(COLcid);
			int vendorId=rs.getInt(COLvid);
			String vendorName=rs.getString(COLvname);
			int menuId=rs.getInt(COLmid);
			String menuName=rs.getString(COLmname);
			int menuPrice=rs.getInt(COLmprice);
			int quantity=rs.getInt(COLquantity);
			int discount=rs.getInt(COLdiscount);
		    		    
		    

			Cart cart=new Cart(cartId,vendorId,vendorName,menuId,menuName,menuPrice,quantity,discount);
			allCartList.add(cart);
			return cart;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
	
	
	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		PreparedStatement pst;
		try {
			Connection connection=DBConnection.getConnection();
			String sqlQuery="update "+TABLEcart+" set "+COLquantity+"=?"+" where "+COLcid+"=?";
			pst = connection.prepareStatement(sqlQuery);
			
			pst.setInt(1,cart.getQuantity());
			pst.setInt(2,cart.getCartId());
			 
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

	
	
	
	
	
	
	
	
	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		
		allCartList=new ArrayList<Cart>();
		try {
			
			
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEcart;
			
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			
			while(rs.next())
			{
			    int cartId=rs.getInt(COLcid);
				int vendorId=rs.getInt(COLvid);
				String vendorName=rs.getString(COLvname);
				int menuId=rs.getInt(COLmid);
				String menuName=rs.getString(COLmname);
				int menuPrice=rs.getInt(COLmprice);
				int quantity=rs.getInt(COLquantity);
				int discount=rs.getInt(COLdiscount);
			
				Cart cart=new Cart(cartId,vendorId,vendorName,menuId,menuName,menuPrice,quantity,discount);
				
				allCartList.add(cart);
				
			}
			
			
			
			return  allCartList;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;

		
		
	}
	
	
	

}
