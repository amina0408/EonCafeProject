package com.model;


/**
 * 
 * @author User
 *
 */
public class Customer {

	private int cid;
	private String cname,cemail,cpassword;
	
	/**
	 * 
	 * @param cid represents customer id
	 * @param cname reprsents customer name
	 * @param cemail reprsents customer email id
	 * @param cpassword reprsents customer password
	 */
	public Customer(int cid, String cname, String cemail, String cpassword) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cemail = cemail;
		this.cpassword = cpassword;
	}
	public Customer() {
		
		
	}
	
	/**
	 * This method is used to get the customer id
	 * @return customer id
	 */
	public int getCid() {
		return cid;
	}
	
	/**
	 * 
	 * @param cid customer id
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	/**
	 * 
	 * @return customer name
	 */
	public String getCname() {
		return cname;
	}
	
	/**
	 * 
	 * @param cname customer name
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	/**
	 * 
	 * @return customer email
	 */
	public String getCemail() {
		return cemail;
	}
	
	/**
	 * 
	 * @param cemail customer email
	 */
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	/**
	 * 
	 * @return cpassword customer password
	 */
	public String getCpassword() {
		return cpassword;
	}
	
	/**
	 * 
	 * @param cpassword customer password
	 */
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", cemail=" + cemail + ", cpassword=" + cpassword + "]";
	}
	@Override
	public boolean equals(Object ob)
	{
		try
		{
		Customer customer=(Customer)ob;
		if(this.cid==customer.cid)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}
	
}
