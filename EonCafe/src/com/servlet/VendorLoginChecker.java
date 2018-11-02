package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.main.DBConnection;

/**
 * Servlet implementation class VendorLoginChecker
 */
@WebServlet("/VendorLoginChecker")
public class VendorLoginChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VendorLoginChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		 String vendorid=request.getParameter("userid").trim();
			String pwd=request.getParameter("password").trim();
			System.out.println("reading the username and password "+ vendorid + " " + pwd);
			
			HttpSession session=request.getSession();
		    session.setAttribute("vid",vendorid);
		    session.setAttribute("vpassword",pwd);
			
		    PrintWriter writer=response.getWriter();
			Connection con = null;
			DBConnection dbm = new DBConnection();
			try
			{
			
				System.out.println("in try");
				
				PrintWriter out = response.getWriter();
				
				try
				{
					if(vendorid!=null)
					{
					 con = dbm.getConnection();
					String sql = "SELECT * FROM Vendor WHERE vid=? AND vpassword=?";
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, vendorid);
					ps.setString(2, pwd);
					
					ResultSet rs = ps.executeQuery();
					if(rs.next())
					{
						
						
						response.sendRedirect("ViewVendorOperation.jsp");
						
					}
					else
					{
						
						response.sendRedirect("ViewVendorLogin.jsp");
						System.out.println("once again login");
						
					}
					
				}
				}
			
				catch(Exception e)
				{
					out.print("Sorry Unable to Communicate with Database...");
					e.printStackTrace();
				}
			}
				finally
				{
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
