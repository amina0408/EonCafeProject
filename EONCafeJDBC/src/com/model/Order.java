package com.model;
/**
 * 
 * @author User
 *This class provides functions of order
 */
public class Order {

	private int oid,cid,vid,mid;
	private String cname,cemail,mname;
	//private byte status;
	/**
	 * 
	 * @param cid reprsents customer id
	 * @param vid represents vendor id
	 * @param mid represents menu id
	 * @param cname reprsents customer name
	 * @param cemail represents customer email
	 * @param mname represents menu name
	 */
	public Order(int cid, int vid, int mid, String cname, String cemail,String mname) {
		super();
		//this.oid = oid;
		this.cid = cid;
		this.vid = vid;
		this.mid = mid;
		this.cname = cname;
		this.cemail = cemail;
		this.mname = mname;
	}
	
	/**
	 * 
	 * @param oid represents the order id
	 * @param cid reprsents customer id
	 * @param vid represents vendor id
	 * @param mid represents menu id
	 * @param cname reprsents customer name
	 * @param cemail represents customer email
	 * @param mname represents menu name
	 */
	public Order(int oid,int cid, int vid, int mid, String cname, String cemail,String mname) {
		super();
		this.oid = oid;
		this.cid = cid;
		this.vid = vid;
		this.mid = mid;
		this.cname = cname;
		this.cemail = cemail;
		this.mname = mname;
	}
	public Order() {
		//super();
	}
	
	/**
	 * this function is used to get the customer id
	 * @return customer id
	 */
	public int getCid() {
		return cid;
	}
	
	/**
	 * this function is used to set the customer id
	 * @param cid
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	/**
	 * this function is used to get the vendor id
	 * @return
	 */
	public int getVid() {
		return vid;
	}
	
	/**
	 * This function is used to set the vendor id
	 * @param vid
	 */
	public void setVid(int vid) {
		this.vid = vid;
	}
	
	/**
	 * This method is used to get the menu id
	 * @return menu id
	 */
	public int getMid() {
		return mid;
	}
	
	/**
	 * 
	 * @param menu id
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	/**
	 * 
	 * @return customer mail
	 */
	public String getCname() {
		return cname;
	}
	/**
	 * 
	 * @param cname is customer name
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	
	/**
	 * 
	 * @return cemail customer email
	 */
	public String getCemail() {
		return cemail;
	}
	
	/**
	 * 
	 * @param cemail
	 */
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	
	/*
	public byte isStatus() {
		return status;
	}
	public void setStatus(byte status) {
		this.status = status;
	}*/
	
	/**
	 * 
	 * @return mname
	 */
	public String getMname() {
		return mname;
	}
	
	/**
	 * 
	 * @return oid order id
	 */
	public int getOid() {
		return oid;
	}
	
	/**
	 * 
	 * @param oid order is
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}
	
	/**
	 * 
	 * @param mname menu name
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public boolean equals(Object ob)
	{
		try
		{
		Order order=(Order)ob;
		if(this.oid==order.oid)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", cid=" + cid + ", vid=" + vid + ", mid=" + mid + ", cname=" + cname + ", cemail="
				+ cemail + ", mname=" + mname + "]";
	}
	
	
	
	
}

