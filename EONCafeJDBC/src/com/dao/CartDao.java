package com.dao;

import java.util.List;

import com.model.Cart;
import com.model.Menu;

public interface CartDao {
	String TABLEcart="Cart",COLcid="cid",COLmid="mid",COLvid="vid",COLmname="mname",COLmprice="mprice",COLvname="vname",COLquantity="quantity",COLdiscount="discount";

	void addCart(Cart cart)throws CartExistsException;

	void deleteCart(Cart cart);

	Cart getcart(int cid);

	void updateCart(Cart cart);

	List<Cart> getAllCart();






}
