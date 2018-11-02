package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.VendorDao;
import com.dao.VendorDaoImpl;
import com.dao.VendorExistsException;

import com.model.Vendor;

/**
 * Servlet implementation class AddVendorServlet
 */
@WebServlet("/AddVendorServlet")
public class AddVendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVendorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		
		writer.append("<html><head><title>Data Servlet</title></head>");
		writer.append("<body>");
		
		
		String vendorId=request.getParameter("Vendor Id");
		int vendorId1=Integer.parseInt(vendorId);
		String vendorName=request.getParameter("Vendor name");
		//int vendorName = Integer.parseInt(vendorName);
		String email=request.getParameter("email");
		//int sid=Integer.parseInt(temp_sid);
		String password=request.getParameter("password");
		
	
		
		
		System.out.println("details of new vendor:"+vendorName+email+password);
		
		//EnrollmentServiceimpl enrollmentServiceimpl = new EnrollmentServiceimpl();
		VendorDaoImpl vendorDao=new VendorDaoImpl();
		
		Vendor vendor=new Vendor(vendorId1,vendorName,password,email);
		
		
	
		try
		{
			vendorDao.addVendor(vendor);
			
		}catch(VendorExistsException e)
		{
			e.printStackTrace();
		}
		
		writer.append("Vendor Added Successfully");
	
	
		writer.append("<a href=\"ViewAdminOperation.jsp\"> Back  </a>");
}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
