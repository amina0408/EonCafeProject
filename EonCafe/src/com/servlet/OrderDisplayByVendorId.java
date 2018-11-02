package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.MenuDaoImpl;
import com.dao.OrderDaoImpl;

import com.model.Order;
import com.service.OrderService;


/**
 * Servlet implementation class OrderDisplayByVendorId
 */
@WebServlet("/OrderDisplayByVendorId")
public class OrderDisplayByVendorId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderDisplayByVendorId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter writer=response.getWriter();
	  	HttpSession session = request.getSession();

	  	int vendorid=Integer.parseInt(session.getAttribute("vid").toString());
	  	//Integer vendorid = (Integer) session.getAttribute("vid");
	  
	  	//OrderDaoImpl orderdao = new OrderDaoImpl();  
	  //	List<Order> orderList=new ArrayList<>();
	  	//List<Order> orderByVendorId = orderdao.getOrderByVendorId(vendorid);
		
	  	OrderService orderservice=new OrderService();
	  	List<Order> orderbyvendorid = orderservice.getorderbyvendorid(vendorid);	//get the list of order by vendor id
	  	for(int i=0;i<orderbyvendorid.size();i++)
	  	{
	  	System.out.println(orderbyvendorid.get(i));
	  	}
	  	//Order orderByVendorId = orderdao.getOrderByVendorId(vendorid);
	  	//orderList.add(orderByVendorId);

	  	//orderList.add(orderdao.getOrderByVendorId(vendorid));
	  	//for(Order or1:orderByVendorId)
	  	//{
	  	request.setAttribute("orderList", orderbyvendorid); 
	  	
	  	//}
       RequestDispatcher rs = request.getRequestDispatcher("ViewOrderByVendor.jsp");  
      rs.forward(request, response); 
        
        //response.sendRedirect("ViewOrderByVendor.jsp");
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
