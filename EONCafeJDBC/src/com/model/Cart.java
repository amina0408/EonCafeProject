package com.model;

public class Cart {

	private int cartId,vid,mid,discount,mprice,quantity;
	private String mname,vname;
	
	public Cart(int cartId,int vid, String vname, int mid,String mname,int mprice,  int quantity, int discount 
			) {
		super();
		this.cartId = cartId;
		this.vid = vid;
		this.vname = vname;
		this.mid = mid;
		this.mname = mname;
		this.mprice = mprice;
		this.quantity = quantity;
		this.discount = discount;
		
		
		
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", vid=" + vid + ", mid=" + mid + ", discount=" + discount + ", mname="
				+ mname + ", vname=" + vname + ", mprice=" + mprice + ", quantity=" + quantity + "]";
	}
	public Cart() {
		//super();
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public int getMprice() {
		return mprice;
	}
	public void setMprice(int mprice) {
		this.mprice = mprice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	@Override
	public boolean equals(Object ob)
	{
		try
		{
		Cart cart=(Cart)ob;
		if(this.cartId==cart.cartId)
			return true;
		return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	}
	
	
	
}
