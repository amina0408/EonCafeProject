package com.dao;

import java.util.List;

import com.model.Vendor;


/**
 * 
 * @author User
 *This interface provides following functions
 *{@link com.dao.VendorDaoImpl#addVendor(Vendor)}
 *{@link com.dao.VendorDaoImpl#deleteVendor(Vendor)}
 *{@link com.dao.VendorDaoImpl#getAllVendors()}
 *{@link com.dao.VendorDaoImpl#getVendor(int)}
 */
public interface VendorDao {

	String TABLEvendor="Vendor",COLvid="vid",COLvname="vname";
	String COLvpassword="vpassword",COLvemail="vemail";
	//List<Vendor> getAllVendors();
	//void addVendor(Vendor v) throws VendorExistsException;
	void addVendor(Vendor v) throws VendorExistsException;
	void deleteVendor(Vendor v);
	List<Vendor> getAllVendors();
	Vendor getVendor(int vid);
	
	
	
	
}
