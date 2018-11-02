package com.service;

import java.util.List;

import com.dao.VendorExistsException;
import com.model.Vendor;
/**
 * 
 * @author User
 * This includes follwing methods
 *{@link com.dao.VendorDaoImpl#addVendor(Vendor)}
 *{@link com.dao.VendorDaoImpl#deleteVendor(Vendor)}
 *{@link com.dao.VendorDaoImpl#getAllVendors()}
 *{@link com.dao.VendorDaoImpl#getVendor(int)}
 *
 */
public interface VendorServiceInterface {

	void addVendor(Vendor v) throws VendorExistsException;
	void deleteVendor(Vendor v);
	List<Vendor> getAllVendor();
	Vendor getvendor(int vid);
  boolean sendMail(String vendorMailId,String customerMailId,String password,int oid);
boolean isDiscountAvailable();
int getDiscount(int totalPrice);
	
	
}
