package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.OrderExistsException;
import com.model.Customer;
import com.model.Menu;
import com.model.Order;
import com.service.CustomerService;
import com.service.MenuService;
import com.service.OrderService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/CartOrderServlet")
public class CartOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String action = request.getParameter("action");

		if ("Add_items_to_cart".equals(action)) {
		    
			PrintWriter writer=response.getWriter();
			MenuService menuService=new MenuService();
			
			String[] selectedValues=request.getParameterValues("checkboxgroup");	//get the checked parameters from jsp page
			String[] quantity = request.getParameterValues("quantity1");	//get the quantity from dropdown list
			
			
			List<Menu> selectedMenu=new ArrayList<Menu>();		//list of menus selected
			
			
			for(int i=0;i<selectedValues.length;i++)		//get the menu by using menu id and add it into menuSelectedList
			{
				int selectedItemId = Integer.parseInt(selectedValues[i]);
				Menu getmenuObj = menuService.getmenu(selectedItemId);
				selectedMenu.add(getmenuObj);
				
			}
			
			
			//int quantity1=Integer.parseInt(quantity);
			//for(Menu selectmenu:selectedMenu)
			for(int i=0;i<selectedMenu.size();i++)//display the menus and their respective quantity
			{
				writer.println("<br>");
				int selectedquantity = Integer.parseInt(quantity[i]);
				
				writer.println( "<tr><td>"+"MenuId= "+selectedMenu.get(i).getMid()+ " "+"VendorId= "+selectedMenu.get(i).getVid()+" "+"MenuName= "+selectedMenu.get(i).getMname()+" "+"MenuPrice= "+selectedMenu.get(i).getMprice()+" "+"VendorName= "+selectedMenu.get(i).getVname()+" "+"Quantity= "+selectedquantity+"</td></tr>");
				writer.println("<br>");
			}
			
			
			
			
			
		}
		
		else if ("Order".equals(action))
		{
		    // Invoke SecondServlet's job here.
			HttpSession session = request.getSession();

		  	int customerid=Integer.parseInt(session.getAttribute("cid").toString());
			PrintWriter writer=response.getWriter();
			MenuService menuService=new MenuService();
			//String language="";
			String[] selectedValues=request.getParameterValues("checkboxgroup");
			//String[] selectedValues1=request.getParameterValues("checkboxgroup1");
			
			String[] quantity = request.getParameterValues("quantity1");
			List<Menu> selectedMenu=new ArrayList<Menu>();
			
			
			for(int i=0;i<selectedValues.length;i++)
			{
				int selectedItemId = Integer.parseInt(selectedValues[i]);
				Menu getmenuObj = menuService.getmenu(selectedItemId);
				selectedMenu.add(getmenuObj);
				
			}
			
			OrderService orderService=new OrderService();
			CustomerService customer=new CustomerService();
			Customer customerinfo = customer.getCustomer(customerid);
			
			for(int i=0;i<selectedMenu.size();i++)
			{
				writer.println("<br>");
				//int selectedquantity = Integer.parseInt(quantity[i]);
				int menuid=selectedMenu.get(i).getMid();
				
				int vendorId=selectedMenu.get(i).getVid();
				
				String menuName=selectedMenu.get(i).getMname();
				
				//int menuPrice=selectedMenu.get(i).getMprice();
				String vendorName=selectedMenu.get(i).getVname();
				
				String customerEmail = customerinfo.getCemail();
				
				String customerName = customerinfo.getCname();
				
				//String customerEmail="shaikhamina0408@gmail.com";
				//String customerName="Amina Shaikh";
				Order order=new Order(customerid,vendorId,menuid,customerName,customerEmail,menuName);
				
				try {
					orderService.addorder(order);
					
				} catch (OrderExistsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//writer.println( "<tr><td>"+"MenuId= "+selectedMenu.get(i).getMid()+ " "+"VendorId= "+selectedMenu.get(i).getVid()+" "+"MenuName= "+selectedMenu.get(i).getMname()+" "+"MenuPrice= "+selectedMenu.get(i).getMprice()+" "+"VendorName= "+selectedMenu.get(i).getVname()+" "+"Quantity= "+selectedquantity+"</td></tr>");
				writer.println("<br>");
			}
			
			writer.println("<tr><td>"+"Your order has been received.The restaurant will revert back after few minutes");
			writer.append("<a href=\"ViewHomePage.jsp\"> Logout  </a>");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
