package com.model;

/**
 * 
 * @author User
 *
 */
public class Menu {

	private int mid,vid,mprice;
	private String mname,vname;
	
	/**
	 * 
	 * @param mid represents menu is
	 * @param vid represents vendor id
	 * @param mname represents menu name
	 * @param mprice represents menu price
	 * @param vname represents vendor name
	 */
	public Menu(int mid, int vid, String mname, int mprice, String vname) {
		super();
		this.mid = mid;
		this.vid = vid;
		this.mname = mname;
		this.mprice = mprice;
		this.vname = vname;
	}
	public Menu(int vid, String mname, int mprice, String vname) {
		super();
		//this.mid = mid;
		this.vid = vid;
		this.mname = mname;
		this.mprice = mprice;
		this.vname = vname;
	}
	
	public Menu() {
		
	}
	
	/**
	 * 
	 * @return mid menu id
	 */
	public int getMid() {
		return mid;
	}
	
	/**
	 * 
	 * @param mid menu id
	 */
	public void setMid(int mid) {
		this.mid = mid;
	}
	
	/**
	 * 
	 * @return vid vendor id
	 */
	public int getVid() {
		return vid;
	}
	
	/**
	 * 
	 * @param vid vendor id
	 */
	public void setVid(int vid) {
		this.vid = vid;
	}
	
	/**
	 * 
	 * @return mname menu name
	 */
	public String getMname() {
		return mname;
	}
	
	/**
	 * 
	 * @param mname menu name
	 */
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	/**
	 * 
	 * @return mprice menu price
	 */
	public int getMprice() {
		return mprice;
	}
	
	/**
	 * 
	 * @param mprice menu price
	 */
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	
	/**
	 * 
	 * @return vendor name
	 */
	public String getVname() {
		return vname;
	}
	
	/**
	 * 
	 * @param vname vendor name
	 */
	public void setVname(String vname) {
		this.vname = vname;
	}
	@Override
	public String toString() {
		return "Menu [mid=" + mid + ", vid=" + vid + ", mname=" + mname + ", mprice=" + mprice + ", vname=" + vname
				+ "]";
	}
	
	@Override
	public boolean equals(Object ob)
	{
		try
		{
		Menu menu=(Menu)ob;
		if(this.mid==menu.mid)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}
	
	
}
