package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.VendorDaoImpl;
import com.model.Order;
import com.model.Vendor;
import com.service.OrderService;
import com.service.VendorService;
import com.service.VendorServiceInterface;

/**
 * Servlet implementation class VendorSendingMailServlet
 */
@WebServlet("/VendorSendingMailServlet")
public class VendorSendingMailServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorSendingMailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//Order order=request.getParameter("order");
		PrintWriter writer=response.getWriter();
		
		OrderService orderService = new OrderService();
		HttpSession session=request.getSession();
		Object attribute = session.getAttribute("vid");
		Integer vid1=Integer.parseInt(attribute.toString());
		
		VendorDaoImpl vendor=new VendorDaoImpl();
		Vendor vendor2 = vendor.getVendor(vid1);
		
	
		String vendor_mail=vendor2.getVemail();
		System.out.println(vendor_mail);
		String vendor_password=vendor2.getVpassword();
		VendorService vendorService = new VendorService();
		
		List<Order> allOrders = orderService.getAllOrders();
		
		
		/*for(Order order:allOrders)
		{
			System.out.println(order);
			
		}*/
		
		List<Order>ordersVidList = new ArrayList<Order>();
		for(Order order : allOrders)
			{
			
			
			if(order.getVid()==vid1)
			{
				
				ordersVidList.add(order);
			}
			    
				
			
			}
		
		for(int i=0;i<ordersVidList.size();i++)
		{
			System.out.println(ordersVidList.get(i));
		}
		for(Order order4 :ordersVidList)
		{
			String cemail = order4.getCemail();
		
			boolean status = vendorService.sendMail(vendor_mail, cemail, vendor_password,order4.getOid());
			if(status)
				{
					writer.println("Message Sent Successfully!!");
					
					orderService.deleteorder(order4.getOid());
				}
			
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
