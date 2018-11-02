package com.model;

/**
 * 
 * @author User
 *
 */
public class Vendor {

	private int vid;
	private String vname,vpassword,vemail;
	/**
	 * 
	 * @param vid represents vendor id
	 * @param vname represents vendor name
	 * @param vpassword represents vendor password
	 * @param vemail reprsents vendor email
	 */
	public Vendor(int vid, String vname, String vpassword,String vemail) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.vpassword = vpassword;
		this.vemail = vemail;
	}
	public Vendor() {
		
	}
	/**
	 * this function gets the vendor id
	 * @return vendor id
	 */
	public int getVid() {
		return vid;
	}
	/**
	 * this function is used to set the vendor id
	 * @param vid represents vendor id
	 */
	public void setVid(int vid) {
		this.vid = vid;
	}
	/**
	 * this function is used to get the vendor name
	 * @return vname
	 */
	
	public String getVname() {
		return vname;
	}
	/**
	 * 
	 * @param vname represents vendor name
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	/**
	 * This function is used to get the vendor password
	 * @return
	 */
	public String getVpassword() {
		return vpassword;
	}
	/**
	 * 
	 * @param vpassword represents vendor password
	 */
	public void setVpassword(String vpassword) {
		this.vpassword = vpassword;
	}
	
	/**
	 * This function is used to get the vendor email
	 * @return
	 */
	public String getVemail() {
		return vemail;
	}
	
	/**
	 * 
	 * @param vemail represents vendor email
	 */
	public void setVemail(String vemail) {
		this.vemail = vemail;
	}
	
	
	
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vname=" + vname + ", vpassword=" + vpassword + ", vemail=" + vemail + "]";
	}
	@Override
	public boolean equals(Object ob)
	{
		try
		{
		Vendor vendor=(Vendor)ob;
		if(this.vid==vendor.vid)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}
	
	
}
