package com.service;

import java.util.ArrayList;
import java.util.List;

import com.dao.CartDao;
import com.dao.CartDaoImpl;
import com.dao.CartExistsException;
import com.model.Cart;
import com.model.Menu;

/**
 * 
 * @author User
 *This class provides functions of cart
 */
public class CartService implements CartServiceInterface{

	private static List<Cart> allCartList=new ArrayList<Cart>();
	CartDao cartdaoimpl=new CartDaoImpl();

		/*public Cart getCart(int cid)
		{
			Cart cart=cartdaoimpl.getcart(cid);
			return cart;
			
		}*/
		/**
		 * This function is used to add items to the cart
		 * 
		 */
		public void addCart(Cart cart) throws CartExistsException
		{
			cartdaoimpl.addCart(cart);
		}
		/**
		 * This function is used to get the list of items inside cart
		 * @return list of items inside the cart
		 */
		public List<Cart> getAllCart()
		{
			allCartList = new ArrayList<Cart>();
			allCartList = cartdaoimpl.getAllCart();
			return allCartList;
		}
		
		/**
		 * This function is used to update the cart
		 */
		public void updateCart(Cart cart)
		{
			cartdaoimpl.updateCart(cart);
		}
		/**
		 * This function is used to delete the items from the cart
		 */
		public void deleteCart(Cart cart)
		{
			cartdaoimpl.deleteCart(cart);
		}

		/**
		 * This function is used to get the items inside the cart
		 * @param cid represents customer id
		 */
		public Cart getcart(int cid) {
			Cart cart=cartdaoimpl.getcart(cid);
			return cart;
		}

		
		
}
