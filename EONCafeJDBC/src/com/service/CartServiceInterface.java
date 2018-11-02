package com.service;

import java.util.List;

import com.dao.CartExistsException;
import com.model.Cart;


/**
 * 
 * @author User
 *This interface provides following functions
 *{@link com.dao.CartDaoImpl#addCart(Cart)}
 *{@link com.dao.CartDaoImpl#deleteCart(Cart)}
 *{@link com.dao.CartDaoImpl#getAllCart()}
 *{@link com.dao.CartDaoImpl#getcart(int)}
 *{@link com.dao.CartDaoImpl#updateCart(Cart)}
 */
public interface CartServiceInterface {

	
	void addCart(Cart cart)throws CartExistsException;

	void deleteCart(Cart cart);

	Cart getcart(int cid);

	void updateCart(Cart cart);

	List<Cart> getAllCart();
	
}
