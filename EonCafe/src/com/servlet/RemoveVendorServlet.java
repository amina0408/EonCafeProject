package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VendorDaoImpl;
import com.dao.VendorExistsException;
import com.model.Vendor;

/**
 * Servlet implementation class RemoveVendorServlet
 */
@WebServlet("/RemoveVendorServlet")
public class RemoveVendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveVendorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.append("<html><head><title>Data Servlet</title></head>");
		writer.append("<body>");
		
		
		
		String vendorName=request.getParameter("Vendor name");
		//int vendorName = Integer.parseInt(vendorName);
		String email=request.getParameter("email");
		//int sid=Integer.parseInt(temp_sid);
		//String password=request.getParameter("password");
		
	
		
		
		System.out.println("details of deleted vendor:"+vendorName+email);
		//EnrollmentServiceimpl enrollmentServiceimpl = new EnrollmentServiceimpl();
		VendorDaoImpl vendorDao=new VendorDaoImpl();
		//Vendor vendor=new Vendor(13,vendorName,password,email);
		
		
		
	
		try
		{
			//vendorDao.addVendor(vendor);
			vendorDao.deleteVendor(vendorDao.getVendor(13));
			
		}catch(Exception e)
		{
			System.out.println("e");
		}
		
		writer.append("Vendor deleted Successfully");
	
	
	


		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
